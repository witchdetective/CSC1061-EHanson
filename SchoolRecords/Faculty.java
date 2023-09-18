/**
 * This class creates faculty members.
 */
public class Faculty extends Employee {
    /**  Private data members. */
    private int hours;
    private String rank;

    
    /** 
     * The getter for hours.
     * @return int
     */
    public int getHours() {
        return hours;
    }

    
    /** 
     * The setter for hours.
     * @param hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    
    /** 
     * The getter for rank.
     * @return String
     */
    public String getRank() {
        return rank;
    }

    
    /** 
     * The setter for rank.
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    
    /** 
     * Overridden toString method.
     * @return String
     */
    @Override
    public String toString() {
        return "Type Faculty: " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", " + getOffice() + ", " + getSalary() + ", " + getDate() + 
        ", " + hours + ", " + rank;
    }
}