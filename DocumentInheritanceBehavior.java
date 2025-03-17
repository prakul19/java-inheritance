import java.util.Scanner;

public class DocumentInheritanceBehavior {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee type (Permanent/Contract): ");
            String type = scanner.nextLine();

            Employee employee;

            // Creating appropriate Employee object based on type
            if (type.equalsIgnoreCase("Permanent")) {
                employee = new PermanentEmployee(name);
            } else if (type.equalsIgnoreCase("Contract")) {
                employee = new ContractEmployee(name);
            } else {
                throw new IllegalArgumentException("Invalid employee type!");
            }

            // Displaying employee details
            System.out.println(employee.getDetails());
            employee.work();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return "Employee Name: " + name;
    }

    public abstract void work();
}

class PermanentEmployee extends Employee {
    public PermanentEmployee(String name) {
        super(name);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Type: Permanent";
    }

    @Override
    public void work() {
        System.out.println(getName() + " works full-time.");
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(String name) {
        super(name);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Type: Contract";
    }

    @Override
    public void work() {
        System.out.println(getName() + " works part-time.");
    }
}

/*
Input and Output:
Enter employee name: prakul
Enter employee type (Permanent/Contract): Permanent
Employee Name: prakul, Type: Permanent
prakul works full-time.
*/
