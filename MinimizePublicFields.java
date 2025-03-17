import java.util.Scanner;

public class MinimizePublicFields {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter person name: ");
            String name = scanner.nextLine();
            System.out.print("Enter person age: ");
            int age = scanner.nextInt();

            // Creating Student object
            Student student = new Student(name, age);

            // Displaying details
            System.out.println(student.getDetails());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Superclass
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}

// Subclass
class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public String getDetails() {
        return "Student Name: " + getName() + ", Age: " + getAge();
    }
}

/*
Input and Output:
Enter person name: prakul
Enter person age: 21
Student Name: Alice, Age: 21
*/
