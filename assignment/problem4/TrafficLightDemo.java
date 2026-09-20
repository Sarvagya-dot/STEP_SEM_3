public class TrafficLightDemo {

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight("TL-9");

        System.out.println("getColor() -> " + trafficLight.getColor());
        System.out.println("next() -> " + trafficLight.next());
        System.out.println("next() -> " + trafficLight.next());
        System.out.println("next() -> " + trafficLight.next());
    }
}

class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    public String getColor() {
        return color;
    }
}
