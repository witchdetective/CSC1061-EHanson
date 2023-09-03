class Employee { // Begin parent class.
    // Private variables.
    private String firstName;
    private String lastName;
    private int social;
    private double paymentAmount;
    // Constructors.
    public Employee() {

    }

    public Employee(String firstName, String lastName, int social, double paymentAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.social = social;
        this.paymentAmount = paymentAmount;
    }
    // Accessors and mutators.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getSocial() {
        return social;
    }
    // To be overridden in child classes.
    public String toString() {
        return firstName + "\n" + lastName + "\n";
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}