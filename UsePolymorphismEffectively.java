import java.util.ArrayList;
import java.util.List;

public class UsePolymorphismEffectively {
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();

        // Adding different types of employees
        employees.add(new Manager("Prakul", 5000));
        employees.add(new Developer("Parth", 3000, "Java"));
        employees.add(new Designer("Parag", 4000, "UI/UX"));

        // Iterating through the list and using polymorphism to display details
        for (Employee employee : employees) {
            System.out.println(employee.getDetails());
            employee.performDuties();
            System.out.println();
        }
    }
}

// Superclass
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

    // Method to get employee details
    public String getDetails() {
        return "Employee Name: " + name + ", Salary: $" + salary;
    }

    // Abstract method for performing duties
    public abstract void performDuties();
}

// Manager subclass
class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " manages the team and oversees projects.");
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
    public String getDetails() {
        return super.getDetails() + ", Programming Language: " + programmingLanguage;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " writes and maintains code in " + programmingLanguage + ".");
    }
}

// Designer subclass
class Designer extends Employee {
    private String specialization;

    public Designer(String name, double salary, String specialization) {
        super(name, salary);
        this.specialization = specialization;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Specialization: " + specialization;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " designs creative solutions for " + specialization + ".");
    }
}

/*
Input and Output:
Employee Name: prakul, Salary: $5000.0
prakul manages the team and oversees projects.

Employee Name: parth, Salary: $3000.0, Programming Language: Java
Bob writes and maintains code in Java.

Employee Name: parag, Salary: $4000.0, Specialization: UI/UX
Charlie designs creative solutions for UI/UX.
*/
