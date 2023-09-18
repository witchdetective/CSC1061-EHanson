public class Faculty extends Employee {
    // Private data members.
    private int hours;
    private String rank;

    // Getters and setters.
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Type Faculty: " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", " + getOffice() + ", " + getSalary() + ", " + getDate() + 
        ", " + hours + ", " + rank;
    }
}