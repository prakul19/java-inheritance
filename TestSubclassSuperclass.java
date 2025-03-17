public class TestSubclassSuperclass {
    public static void main(String[] args) {
        // Creating a superclass object
        Vehicle vehicle = new Vehicle("Generic Vehicle");
        System.out.println(vehicle.getDetails());
        vehicle.move();

        System.out.println();

        // Creating a subclass object
        Car car = new Car("Sedan", 4);
        System.out.println(car.getDetails());
        car.move();
    }
}

// Superclass representing a generic vehicle.

class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public String getDetails() {
        return "Vehicle Type: " + type;
    }

// Move method to simulate vehicle movement.
    public void move() {
        System.out.println(type + " is moving.");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String type, int numberOfDoors) {
        super(type); // Calling the superclass constructor explicitly
        this.numberOfDoors = numberOfDoors;
    }
    @Override
    public String getDetails() {
        return super.getDetails() + ", Number of Doors: " + numberOfDoors;
    }
    @Override
    public void move() {
        super.move();
        System.out.println("The car moves smoothly on the road.");
    }
}

/*
Input and Output:
Vehicle Type: Generic Vehicle
Generic Vehicle is moving.

Vehicle Type: Sedan, Number of Doors: 4
Sedan is moving.
The car moves smoothly on the road.
*/
