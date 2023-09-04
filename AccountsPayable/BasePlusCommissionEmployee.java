public class BasePlusCommissionEmployee extends CommissionEmployee { // Begin child class.
    // Private variables.
    private double basePay;

    // Constructors.
    public BasePlusCommissionEmployee() {

    }

    public BasePlusCommissionEmployee(double basePay) {
        this.basePay = basePay;
    }

    // Accessors and mutators.
    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public double getBasePay() {
        return basePay;
    }

    // Overriden methods.
    public double getPaymentAmount() {
        double comPaymentAmount = super.getPaymentAmount();
        double basePlusComPaymentAmount = basePay + comPaymentAmount;
        return basePlusComPaymentAmount;
    }

    @Override
    public String toString() {
        return getFirstName() + "\n" + getLastName() + "\n" + getPaymentAmount();
    }

}