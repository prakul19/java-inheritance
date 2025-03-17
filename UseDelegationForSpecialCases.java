import java.util.Scanner;

public class UseDelegationForSpecialCases {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter device type (Basic/Advanced): ");
            String type = scanner.nextLine();
            Device device;

            // Using delegation to assign specific behaviors
            if (type.equalsIgnoreCase("Basic")) {
                device = new Device(new BasicPrinterBehavior());
            } else if (type.equalsIgnoreCase("Advanced")) {
                device = new Device(new AdvancedPrinterBehavior());
            } else {
                throw new IllegalArgumentException("Invalid device type!");
            }

            // Performing actions using the delegated behavior
            device.print();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Device class that uses delegation
class Device {
    private final PrinterBehavior printerBehavior;

    public Device(PrinterBehavior printerBehavior) {
        this.printerBehavior = printerBehavior;
    }

    public void print() {
        printerBehavior.print();
    }
}

// Interface for defining printer behavior
interface PrinterBehavior {
    void print();
}

// Implementation of basic printer behavior
class BasicPrinterBehavior implements PrinterBehavior {
    @Override
    public void print() {
        System.out.println("Printing using basic functionality");
    }
}

// Implementation of advanced printer behavior
class AdvancedPrinterBehavior implements PrinterBehavior {
    @Override
    public void print() {
        System.out.println("Printing using advanced functionality with extra features");
    }
}

/*
Input and Output:
Enter device type (Basic/Advanced): Basic
Printing using basic functionality
*/
