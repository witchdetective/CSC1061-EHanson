/**
 * This class creates employees.
 */
public class Employee extends Person {
    /** Private data members. */
    private String office;
    private double salary;
    private String date;

    
    
    /**
     * The getter for office. 
     * @return String
     */
    public String getOffice() {
        return office;
    }

    
    /** 
     * The setter for office.
     * @param office
     */
    public void setOffice(String office) {
        this.office = office;
    }

    
    /** 
     * The getter for salary.
     * @return double
     */
    public double getSalary() {
        return salary;
    }

    
    /** 
     * The setter for salary.
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    /** 
     * The getter for date.
     * @return String
     */
    public String getDate() {
        return date;
    }

    
    /** 
     * The setter for date.
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    /** 
     * Overridden toString method.
     * @return String
     */
    @Override
    public String toString() {
        return getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", " + office + ", " + salary + ", " + date;
    }
}