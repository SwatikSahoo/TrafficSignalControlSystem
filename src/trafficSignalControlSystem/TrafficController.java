package trafficSignalControlSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficController {
    private static TrafficController instance;
    private final Map<String, Road> roads;

    public TrafficController() {
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
            new Thread(()->{
                while(true){
                    try{
                        Thread.sleep(light.getRedTime());
                        light.changeSignal(Signal.GREEN);
                        Thread.sleep(light.getGreTime());
                        light.changeSignal(Signal.YELLOW);
                        Thread.sleep(light.getYelTime());
                        light.changeSignal(Signal.RED);
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
