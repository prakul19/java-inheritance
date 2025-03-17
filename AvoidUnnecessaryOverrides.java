import java.util.Scanner;

public class AvoidUnnecessaryOverrides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter vehicle type (Car/Bike): ");
            String vehicleType = scanner.nextLine();
            Vehicle vehicle;

            // Create the appropriate vehicle instance
            if (vehicleType.equalsIgnoreCase("Car")) {
                System.out.print("Enter car model: ");
                String model = scanner.nextLine();
                vehicle = new Car(model);
            } else if (vehicleType.equalsIgnoreCase("Bike")) {
                System.out.print("Enter bike model: ");
                String model = scanner.nextLine();
                vehicle = new Bike(model);
            } else {
                throw new IllegalArgumentException("Invalid vehicle type!");
            }

            // Displaying vehicle details and honking
            System.out.println(vehicle.getDetails());
            vehicle.honk();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Superclass
class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getDetails() {
        return "Vehicle Model: " + model;
    }

    // Honk method is final because it does not need to be overridden
    public final void honk() {
        System.out.println(model + " honks: Beep! Beep!");
    }
}

// Subclass
class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    // Only extend behavior if needed
    public String getCarDetails() {
        return getDetails() + " (Car-specific details)";
    }
}

// Subclass
class Bike extends Vehicle {
    public Bike(String model) {
        super(model);
    }

    // Only extend behavior if needed
    public String getBikeDetails() {
        return getDetails() + " (Bike-specific details)";
    }
}

/*
Input and Output:
Enter vehicle type (Car/Bike): Car
Enter car model: Honda Civic
Vehicle Model: Honda Civic
Honda Civic honks: Beep! Beep!
*/
