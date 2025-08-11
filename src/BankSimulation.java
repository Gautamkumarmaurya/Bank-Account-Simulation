import java.util.*;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;
    private static final double DAILY_WITHDRAWAL_LIMIT = 10000;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        log("Account created with initial balance: ₹" + initialBalance);
    }

    private void log(String message) {
        transactionHistory.add(new Date() + " - " + message);
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
            log("Deposited ₹" + amount + " | New Balance: ₹" + balance);
        } else {
            log("Failed deposit attempt: ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            log("Invalid withdrawal attempt: ₹" + amount);
        } else if (amount > balance) {
            log("Withdrawal failed: Insufficient balance");
        } else if (amount > DAILY_WITHDRAWAL_LIMIT) {
            log("Withdrawal failed: Above daily limit");
        } else {
            balance -= amount;
            log("Withdrew ₹" + amount + " | New Balance: ₹" + balance);
        }
    }

    public void transferTo(Account target, double amount) {
        if (this == target) {
            log("Transfer failed: Same account");
            return;
        }
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            target.deposit(amount);
            log("Transferred ₹" + amount + " to " + target.accountHolder + " (" + target.accountNumber + ")");
        } else {
            log("Transfer failed: Invalid amount or insufficient funds");
        }
    }

    public void printTransactionHistory() {
        System.out.println("\n📜 Transaction History for " + accountHolder + " (" + accountNumber + "):");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        // Create accounts
        Account acc1 = new Account("1001", "Gautam Kumar", 20000);
        Account acc2 = new Account("1002", "Rahul Sharma", 15000);

        // Simulate real-world events
        acc1.deposit(5000);
        acc1.withdraw(3000);
        acc1.withdraw(12000); // exceeds daily limit
        acc1.transferTo(acc2, 2000);

        acc2.deposit(7000);
        acc2.withdraw(500);
        acc2.transferTo(acc1, 10000);

        // Show final balances
        System.out.println("\n💰 Final Balances:");
        System.out.println(acc1.getAccountNumber() + " - " + acc1.getBalance());
        System.out.println(acc2.getAccountNumber() + " - " + acc2.getBalance());

        // Print transaction history
        acc1.printTransactionHistory();
        acc2.printTransactionHistory();
    }
}
