import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    private LocalDate dateTransaction = LocalDate.now();
    private String type;
    private double amount;
    private double balance;

    public Transactions(String type, double amount, double balance) {
        this.type = type;
        this.amount = amount;

        this.balance = balance;
    }


    public LocalDate getDateTransaction() {
        return this.dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "{" +
            " Date of transaction: " + getDateTransaction() + "'" +
            ", type: " + getType() + "'" +
            ", amount: " + getAmount() + "'" +
            ", balance: " + getBalance() + "'" +
            "}";
    }
    

    



}