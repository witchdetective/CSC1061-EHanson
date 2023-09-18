public class Staff extends Employee {
    // Private data member.
    private String title;

    // Getter and setter.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Type: Staff, " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", "
                + getOffice() + ", " + getSalary() + ", " + getDate() +
                ", " + title;
    }
}