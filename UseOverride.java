import java.util.Scanner;

public class UseOverride {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter shape type (Circle/Rectangle): ");
            String shapeType = scanner.nextLine();
            Shape shape;

            if (shapeType.equalsIgnoreCase("Circle")) {
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
            } else if (shapeType.equalsIgnoreCase("Rectangle")) {
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                shape = new Rectangle(width, height);
            } else {
                throw new IllegalArgumentException("Invalid shape type!");
            }

            // Displaying the calculated area
            System.out.println("Area: " + shape.calculateArea());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Superclass
abstract class Shape {
    public abstract double calculateArea();
}

// Circle subclass
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle subclass
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

/*
Input and Output:
Enter shape type (Circle/Rectangle): Circle
Enter radius: 5
Area: 78.53981633974483
*/
