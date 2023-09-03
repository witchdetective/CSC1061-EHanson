public class SalariedEmployee extends Employee { // Begin child class.
    // Private variables.
    private double weeklySalary;
    // Constructors.
    public SalariedEmployee() {

    }

    public SalariedEmployee(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    // Accessors and mutators.
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }
    // Overridden methods.
    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getSocial() + ", " + getPaymentAmount();
    }

}