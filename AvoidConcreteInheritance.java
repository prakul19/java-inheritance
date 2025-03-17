import java.util.Scanner;

public class AvoidConcreteInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee type (Manager/Developer): ");
            String type = scanner.nextLine();
            Employee employee;

            // Create the appropriate employee object based on input
            if (type.equalsIgnoreCase("Manager")) {
                System.out.print("Enter manager name: ");
                String name = scanner.nextLine();
                System.out.print("Enter manager's salary: ");
                double salary = scanner.nextDouble();
                employee = new Manager(name, salary);
            } else if (type.equalsIgnoreCase("Developer")) {
                System.out.print("Enter developer name: ");
                String name = scanner.nextLine();
                System.out.print("Enter developer's salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter developer's programming language: ");
                String language = scanner.nextLine();
                employee = new Developer(name, salary, language);
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

// Abstract class
abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Abstract method for work behavior
    public abstract void work();

    // Concrete method for employee details
    public String getDetails() {
        return "Employee Name: " + name + ", Salary: $" + salary;
    }
}

// Manager subclass
class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is managing the team.");
    }
}

// Developer subclass
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is coding in " + programmingLanguage + ".");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Programming Language: " + programmingLanguage;
    }
}

/*
Sample Input and Output:
Enter employee type (Manager/Developer): Manager
Enter manager name: prakul
Enter manager's salary: 60000
Employee Name: prakul, Salary: $60000.0
Prakul is managing the team.
*/
