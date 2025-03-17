import java.util.Scanner;

public class UseOfRelationship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the dog's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the dog's breed: ");
            String breed = scanner.nextLine();

            // Creating a Dog object
            Dog dog = new Dog(name, breed);

            // Displaying dog's details and making it perform an action
            System.out.println(dog.getDetails());
            dog.speak();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Superclass
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void speak() {
        System.out.println(name + " makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String getDetails() {
        return "Dog Name: " + getName() + ", Breed: " + breed;
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
}

/*
Input and Output:
Enter the dog's name: snuffy
Enter the dog's breed: GoldenRetreiver
Dog Name: snuffy, Breed: GoldenRetreiver
Max says: Woof! Woof!
*/
