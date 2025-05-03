package trafficSignalControlSystem;

public class TrafficLight {
    private final String id;
    private Signal currSignal;
    private int redTime;
    private int yelTime;
    private int greTime;

    public TrafficLight(String id,int t1, int t2, int t3) {
        this.id = id;
        currSignal=Signal.RED;
        redTime=t1;
        yelTime=t2;
        greTime=t3;
    }
    public void changeSignal(Signal sig){
        currSignal=sig;
    }
    public Signal getCurrSignal(){
        return currSignal;
    }

    public String getId() {
        return id;
    }

    public int getRedTime() {
        return redTime;
    }

    public int getYelTime() {
        return yelTime;
    }

    public int getGreTime() {
        return greTime;
    }
}
