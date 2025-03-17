import java.util.Scanner;

public class AbstractClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter account type (Savings/Current): ");
            String accountType = scanner.nextLine();
            System.out.print("Enter account balance: ");
            double balance = scanner.nextDouble();

            Account account;

            // Creating appropriate Account object based on type
            if (accountType.equalsIgnoreCase("Savings")) {
                account = new SavingsAccount(balance);
            } else if (accountType.equalsIgnoreCase("Current")) {
                account = new CurrentAccount(balance);
            } else {
                throw new IllegalArgumentException("Invalid account type!");
            }

            // Displaying account details
            System.out.println(account.getDetails());
            account.calculateInterest();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Abstract class
abstract class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDetails() {
        return "Account Balance: " + balance;
    }

    // Abstract method for calculating interest
    public abstract void calculateInterest();
}

// SavingsAccount class
class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * 0.04;
        System.out.println("Savings Account Interest: " + interest);
    }
}

// CurrentAccount class
class CurrentAccount extends Account {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current Account has no interest.");
    }
}

/*
Input and Output:
Enter account type (Savings/Current): Savings
Enter account balance: 10000
Account Balance: 10000.0
Savings Account Interest: 400.0

Enter account type (Savings/Current): Current
Enter account balance: 15000
Account Balance: 15000.0
Current Account has no interest.
*/
