import java.util.Scanner;

public class CompositionOverInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter car model: ");
            String model = scanner.nextLine();
            System.out.print("Enter engine type (e.g., Petrol/Diesel): ");
            String engineType = scanner.nextLine();

            // Creating Engine and Car objects
            Engine engine = new Engine(engineType);
            Car car = new Car(model, engine);

            // Displaying car details
            System.out.println(car.getDetails());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Engine class
class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Car class
class Car {
    private String model;
    private Engine engine;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getDetails() {
        return "Car Model: " + model + ", Engine Type: " + engine.getType();
    }
}

/*
Input and Output:
Enter car model: Honda Civic
Enter engine type (e.g., Petrol/Diesel): Diesel
Car Model: Honda Civic, Engine Type: Diesel
*/
