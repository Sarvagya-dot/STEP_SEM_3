import java.util.Scanner;

public class GardenPlotAreaReport {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int plotCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double totalArea = 0;

        for (int plotIndex = 0; plotIndex < plotCount; plotIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

            Plot plot = createPlot(tokens);
            double area = plot.calculateArea();

            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShapeName(), area);
            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        userInputScanner.close();
    }

    private static Plot createPlot(String[] tokens) {
        String shapeType = tokens[0];
        String owner = tokens[1];

        switch (shapeType) {
            case "CIRCLE":
                return new CirclePlot(owner, Double.parseDouble(tokens[2]));
            case "RECTANGLE":
                return new RectanglePlot(owner, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            case "TRIANGLE":
                return new TrianglePlot(owner, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

abstract class Plot {
    protected String owner;
    protected String shapeName;

    Plot(String owner, String shapeName) {
        this.owner = owner;
        this.shapeName = shapeName;
    }

    abstract double calculateArea();

    String getOwner() {
        return owner;
    }

    String getShapeName() {
        return shapeName;
    }
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}
