public class HourlyEmployee extends Employee { // Begin child class.
    // Private variables.
    private double hourlyWage;
    private int hours;
    // Constructors.
    public HourlyEmployee() {

    }

    public HourlyEmployee(double hourlyWage, int hours) {
        this.hourlyWage = hourlyWage;
        this.hours = hours;
    }
    // Accessors and mutators.
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }
    // Overridden methods.
    @Override
    public double getPaymentAmount() {
        double hourlyPaymentAmount = hourlyWage * (double)hours;
        return hourlyPaymentAmount;

    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getSocial() + ", " + getPaymentAmount();
    }
}