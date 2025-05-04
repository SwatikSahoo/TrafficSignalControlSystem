package trafficSignalControlSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TrafficController {
    private static TrafficController instance;
    private final Map<String, Road> roads;

    private TrafficController() {
        roads = new ConcurrentHashMap<>();
    }
    public static synchronized TrafficController getInstance(){
        if (instance==null){
            instance=new TrafficController();
        }
        return instance;
    }
    public void startTrafiicControl(){
        for (Road road:roads.values()){
            TrafficLight light = road.getLight();
            AtomicInteger k= new AtomicInteger(4);
            new Thread(()->{
                while(k.getAndDecrement() >0){
                    try{
                        System.out.println("RED is ON");
                        Thread.sleep(light.getRedTime());
                        light.changeSignal(Signal.GREEN);
                        System.out.println("GREEN is ON");
                        Thread.sleep(light.getGreTime());
                        light.changeSignal(Signal.YELLOW);
                        System.out.println("YELLOW is ON");
                        Thread.sleep(light.getYelTime());
                        light.changeSignal(Signal.RED);
                        System.out.println("RED is ON");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();
        }
    }
    public void handleEmergency(String rdid){
        Road rd= roads.get(rdid);
        if (rd!=null){
            TrafficLight light= rd.getLight();
            light.changeSignal(Signal.GREEN);
        }

    }
    public void addRoad(Road rd){
        roads.put(rd.getId(),rd);
    }
    public void removeRoad(String rdId){
        roads.remove(rdId);
    }

}
