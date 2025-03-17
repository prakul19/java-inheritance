import java.util.Scanner;

public class OverloadingAlongsideOverriding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter rectangle width: ");
            double width = scanner.nextDouble();
            System.out.print("Enter rectangle height: ");
            double height = scanner.nextDouble();

            Rectangle rectangle = new Rectangle(width, height);

            // Displaying area using overridden method
            System.out.println("Area: " + rectangle.calculateArea());

            // Demonstrating overloading - method with different parameter
            System.out.print("Enter scale factor for area: ");
            double scaleFactor = scanner.nextDouble();
            System.out.println("Scaled Area: " + rectangle.calculateArea(scaleFactor));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Superclass
class Shape {
    public double calculateArea() {
        return 0; // Default implementation
    }
}

// Subclass
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height; // Overridden method
    }

    // Overloaded method with additional parameter
    public double calculateArea(double scaleFactor) {
        return calculateArea() * scaleFactor;
    }
}

/*
Input and Output:
Enter rectangle width: 4
Enter rectangle height: 3
Area: 12.0
Enter scale factor for area: 2
Scaled Area: 24.0
*/
