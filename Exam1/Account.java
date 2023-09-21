import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Account {
    private int id = 0;
    private double balance = 0.00;
    private double annualInterestRate = 0.00;
    private LocalDate dateCreated = LocalDate.now();

    private String name;
    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    


    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static int count = 0;

    // Constructors.

    public Account(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public Account(int id, double balance) {
        this.balance = getId + getBalance();
    }

    // Getters and setters.
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id + count++;

    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate / 100;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // Getter for date.
    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        double monthlyInterestRate = getAnnualInterestRate() / 12;
        return monthlyInterestRate;
    }

    public double getMonthlyInterest() {
        double monthlyInterest = balance * (getMonthlyInterestRate() / 100);
        return monthlyInterest;
    }

    public double withdraw(double withdraw) {
        for (List<Transaction> transaction : transactions) {
            transactions.add(transaction);
        }
        return withdraw;
    }

    public void deposit(double balance) {
        balance = getBalance() - withdraw(balance);
    }

    @Override
    public String toString() {
        return "{" +
                " I: " + getId() + "'" +
                ", balance: " + getBalance() + "'" +
                ", monthly interest: " + getMonthlyInterest() + "'" +
                ", dateCreated: " + getDateCreated() + "'" +
                "}";
    }

}
