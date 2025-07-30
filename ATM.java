import java.util.Scanner;

// Step 4: BankAccount class to store and manage account balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// Step 1–7: ATM class with user interface and operations
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println(" Welcome to the ATM!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1.  Withdraw");
            System.out.println("2.  Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4.  Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (account.withdraw(amount)) {
            System.out.println(" Withdrawal successful. New balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Insufficient balance. Current balance: ₹" + account.getBalance());
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println(" Invalid amount.");
        } else {
            account.deposit(amount);
            System.out.println(" Deposit successful. New balance: ₹" + account.getBalance());
        }
    }

    private void handleCheckBalance() {
        System.out.println(" Current Balance: ₹" + account.getBalance());
    }

    // Main method to run the program
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // initial balance ₹1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
