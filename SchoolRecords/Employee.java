public class Employee extends Person {
    // Private data members.
    private String office;
    private double salary;
    private String date;

    // Getters and setters.
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", " + office + ", " + salary + ", " + date;
    }
}