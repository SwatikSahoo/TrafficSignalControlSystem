package trafficSignalControlSystem;

public class Road {
    private final String id;
    private final String name;
    private TrafficLight light;

    public Road(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setTrafficLight(TrafficLight light){
        this.light=light;
    }

    public String getId() {
        return id;
    }

    public TrafficLight getLight() {
        return light;
    }
}
