public class SavingsAccount extends Account {
    private double savings;


    public SavingsAccount() {

    }
    
    public double getSavings() {
        return this.savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }


    @Override
    public String toString() {
        return "{" +
            " savings: " + getSavings() + "'" +
            "}";
    }


}