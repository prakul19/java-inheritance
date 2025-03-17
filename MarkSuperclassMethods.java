import java.util.Scanner;

public class MarkSuperclassMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee role (e.g., Manager/Developer): ");
            String role = scanner.nextLine();

            Employee employee;

            // Creating appropriate Employee object based on role
            if (role.equalsIgnoreCase("Manager")) {
                employee = new Manager(name);
            } else if (role.equalsIgnoreCase("Developer")) {
                employee = new Developer(name);
            } else {
                throw new IllegalArgumentException("Invalid role!");
            }

            // Displaying employee details
            System.out.println(employee.getDetails());
            employee.performDuties();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Superclass
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    // Marking this method final to prevent overriding
    public final String getDetails() {
        return "Employee Name: " + name;
    }

    public void performDuties() {
        System.out.println(name + " performs general duties.");
    }
}

// Manager subclass
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void performDuties() {
        System.out.println(getDetails() + " manages the team.");
    }
}

// Developer subclass
class Developer extends Employee {
    public Developer(String name) {
        super(name);
    }

    @Override
    public void performDuties() {
        System.out.println(getDetails() + " writes code.");
    }
}

/*
Input and Output:
Enter employee name: Prakul
Enter employee role (e.g., Manager/Developer): Manager
Employee Name: Prakul
Employee Name: Prakul manages the team.
*/
