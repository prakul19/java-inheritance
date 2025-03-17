import java.util.Scanner;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter rectangle width: ");
            double width = scanner.nextDouble();
            System.out.print("Enter rectangle height: ");
            double height = scanner.nextDouble();
            Shape rectangle = new Rectangle(width, height);

            System.out.print("Enter square side length: ");
            double side = scanner.nextDouble();
            Shape square = new Square(side);

            // Displaying areas
            System.out.println("Rectangle Area: " + rectangle.calculateArea());
            System.out.println("Square Area: " + square.calculateArea());
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

// Square subclass
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

/*
Input and Output:
Enter rectangle width: 5
Enter rectangle height: 4
Enter square side length: 3
Rectangle Area: 20.0
Square Area: 9.0
*/
