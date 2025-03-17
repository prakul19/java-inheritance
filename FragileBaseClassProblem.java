import java.util.ArrayList;
import java.util.List;

public class FragileBaseClassProblem {
    public static void main(String[] args) {
        // Creating a list of animals
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Snuffy"));
        animals.add(new Cat("Lucy"));

        // Iterating through the animals and displaying their details
        for (Animal animal : animals) {
            System.out.println(animal.getDetails());
            animal.speak();
            System.out.println();
        }
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return "Animal Name: " + name;
    }

    public void speak() {
        System.out.println(name + " makes a sound.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Meow!");
    }
}

/*
Input and Output:
Animal Name: snuffy
Buddy says: Woof! Woof!

Animal Name: Lucy
Buddy says: Woof! Woof!
*/
