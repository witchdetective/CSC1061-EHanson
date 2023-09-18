/**
 * This class is for staff member generation.
 */
public class Staff extends Employee {
    /**  Private data member. */
    private String title;

    
    /** 
     * The getter for title.
     * @return String
     */
    public String getTitle() {
        return title;
    }

    
    /** 
     * The setter for title.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    /** 
     * Overridden toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "Type: Staff, " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", "
                + getOffice() + ", " + getSalary() + ", " + getDate() +
                ", " + title;
    }
}