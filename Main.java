import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // Create 2 test accounts so you can test transfer
        bank.addAccount(new Account("Hulisani", "1001", 1000));
        bank.addAccount(new Account("Bono", "1002", 500));

        while (true) {
            System.out.println("\n=== HULISANI BANK ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                System.out.println("Thank you for banking with Hulisani Bank!");
                break;
            }

            System.out.print("Enter account number: ");
            String accNum = scanner.nextLine();
            Account acc = bank.findAccount(accNum);

            if (acc == null) {
                System.out.println("Account not found!");
                continue;
            }

            if (choice == 1) {
                acc.displayInfo();
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: R");
                double amt = scanner.nextDouble();
                acc.deposit(amt);
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: R");
                double amt = scanner.nextDouble();
                acc.withdraw(amt);
            } else if (choice == 4) {
                System.out.print("Enter TO account number: ");
                String toNum = scanner.nextLine();
                System.out.print("Enter amount to transfer: R");
                double amt = scanner.nextDouble();
                bank.transfer(accNum, toNum, amt);
            } else {
                System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}