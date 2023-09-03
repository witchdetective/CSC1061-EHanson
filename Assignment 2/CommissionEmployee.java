public class CommissionEmployee extends Employee { // Begin child class.
    // Private variables.
    private double grossSales;
    private int commisionRate;
    // Constructors.
    public CommissionEmployee() {

    }

    public CommissionEmployee(double grossSales, int commisionRate) {
        this.grossSales = grossSales;
        this.commisionRate = commisionRate;
    }
    // Accessors and mutators.
    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setCommisionRate(int commisionRate) {
        this.commisionRate = commisionRate;
    }

    public int getCommisionRate() {
        return commisionRate;
    }
    // Overridden methods
    @Override
    public double getPaymentAmount() {
        double comPaymentAmount = grossSales * (double) commisionRate;
        return comPaymentAmount;
    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getSocial() + ", " + getPaymentAmount();
    }

}