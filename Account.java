public class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public Account(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: R" + amount);
        } else {
            System.out.println("Amount must be more than 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: R" + amount);
        } else {
            System.out.println("Not enough balance or invalid amount!");
        }
    }

    public void displayInfo() {
        System.out.println("--- Account Info ---");
        System.out.println("Holder: " + accountHolder);
        System.out.println("Number: " + accountNumber);
        System.out.println("Balance: R" + balance);
    }
}