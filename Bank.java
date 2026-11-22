import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created for " + account.getAccountHolder());
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void transfer(String fromNumber, String toNumber, double amount) {
        Account from = findAccount(fromNumber);
        Account to = findAccount(toNumber);

        if (from == null || to == null) {
            System.out.println("One of the accounts not found!");
            return;
        }

        if (amount > 0 && amount <= from.getBalance()) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer successful! R" + amount + " from " + fromNumber + " to " + toNumber);
        } else {
            System.out.println("Transfer failed - not enough balance!");
        }
    }
}