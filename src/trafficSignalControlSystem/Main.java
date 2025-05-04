package trafficSignalControlSystem;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Road rd1= new Road("R1","left");
        Road rd2= new Road("R2","right");
        Road rd3= new Road("R3","up");
        Road rd4= new Road("R4","down");

        TrafficLight tl1= new TrafficLight("TL1",600,300,1000);
        TrafficLight tl2= new TrafficLight("TL2",600,300,1000);
        TrafficLight tl3= new TrafficLight("TL3",600,300,1000);
        TrafficLight tl4= new TrafficLight("TL4",600,300,1000);

        rd1.setTrafficLight(tl1);
        rd2.setTrafficLight(tl2);
        rd3.setTrafficLight(tl3);
        rd4.setTrafficLight(tl4);

        TrafficController sys= TrafficController.getInstance();

        sys.addRoad(rd1);
        sys.addRoad(rd2);
        sys.addRoad(rd3);
        sys.addRoad(rd4);

        sys.startTrafiicControl();
        sys.handleEmergency("R2");


    }
}