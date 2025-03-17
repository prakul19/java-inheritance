import java.util.Scanner;

public class InterfacesForMultipleInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter device type (Printer/ScanDevice): ");
            String deviceType = scanner.nextLine();

            MultiFunctionDevice device;

            if (deviceType.equalsIgnoreCase("Printer")) {
                device = new MultiFunctionPrinter();
            } else if (deviceType.equalsIgnoreCase("ScanDevice")) {
                device = new MultiFunctionScanner();
            } else {
                throw new IllegalArgumentException("Invalid device type!");
            }

            // Using the device's capabilities
            device.print();
            device.scan();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Printer interface
interface Printer {
    void print();
}

// ScanDevice interface
interface ScanDevice {
    void scan();
}

// MultiFunctionDevice interface
interface MultiFunctionDevice extends Printer, ScanDevice {
    // Combines the capabilities of Printer and ScanDevice
}

// Implementation of MultiFunctionDevice as a Printer
class MultiFunctionPrinter implements MultiFunctionDevice {
    @Override
    public void print() {
        System.out.println("Printing document");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document");
    }
}

// Implementation of MultiFunctionDevice as a ScanDevice
class MultiFunctionScanner implements MultiFunctionDevice {
    @Override
    public void print() {
        System.out.println("Printing is disabled for this device.");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }
}

/*
Input and Output:
Enter device type (Printer/ScanDevice): Printer
Printing document
Scanning document

Enter device type (Printer/ScanDevice): ScanDevice
Printing is disabled for this device.
Scanning document
*/
