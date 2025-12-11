class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        }
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("001", "John Doe", 1000);
        a1.deposit(500);
        a1.withdraw(200);

        SavingsAccount s1 = new SavingsAccount("002", "Alice Smith", 2000, 0.05);
        s1.deposit(300);
        s1.withdraw(500);
        s1.applyInterest();

        a1.printDetails();
        System.out.println();
        s1.printDetails();
    }
}

