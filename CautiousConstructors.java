import java.util.Scanner;

public class CautiousConstructors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee type (Manager/Developer): ");
            String type = scanner.nextLine();

            Employee employee;

            // Creating the appropriate employee object
            if (type.equalsIgnoreCase("Manager")) {
                employee = new Manager(name);
            } else if (type.equalsIgnoreCase("Developer")) {
                employee = new Developer(name);
            } else {
                throw new IllegalArgumentException("Invalid employee type!");
            }

            // Displaying employee details
            System.out.println(employee.getDetails());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getDetails() {
        return "Employee Name: " + name;
    }

    // Avoiding non-final methods in the constructor.
}

class Manager extends Employee {

    public Manager(String name) {
        super(name); // Explicitly calling the superclass constructor
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Role: Manager";
    }
}

class Developer extends Employee {

    public Developer(String name) {
        super(name); // Explicitly calling the superclass constructor
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Role: Developer";
    }
}

/*
Input and Output:
Enter employee name: prakul
Enter employee type (Manager/Developer): Manager
Employee Name: prakul, Role: Manager
*/
