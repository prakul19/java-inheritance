import java.util.Scanner;

public class AvoidDeepInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee role (Manager/Developer): ");
            String role = scanner.nextLine();

            Employee employee;

            // Creating appropriate Employee object based on role
            if (role.equalsIgnoreCase("Manager")) {
                System.out.print("Enter department: ");
                String department = scanner.nextLine();
                employee = new Manager(name, department);
            } else if (role.equalsIgnoreCase("Developer")) {
                System.out.print("Enter programming language: ");
                String language = scanner.nextLine();
                employee = new Developer(name, language);
            } else {
                throw new IllegalArgumentException("Invalid role!");
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

// Superclass
class Employee {
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
}

// Manager subclass
class Manager extends Employee {
    private String department;

    public Manager(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Role: Manager, Department: " + department;
    }
}

// Developer subclass
class Developer extends Employee {
    private String language;

    public Developer(String name, String language) {
        super(name);
        this.language = language;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Role: Developer, Programming Language: " + language;
    }
}

/*
Input and Output:
Enter employee name: prakul
Enter employee role (Manager/Developer): Manager
Enter department: HR
Employee Name: prakul, Role: Manager, Department: HR
*/
