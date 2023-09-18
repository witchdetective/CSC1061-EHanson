/**
 * This class is for student generation.
 */
public class Student extends Person {

    /** Private data member. */
    private String status;

    
    /** 
     * The setter for status.
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    
    /** 
     * The getter for status.
     * @return String
     */
    public String getStatus() {
        return status;
    }

    
    /** 
     * Overridden toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "Type: Student, " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", "
                + status;
    }
}