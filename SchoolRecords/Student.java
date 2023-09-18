public class Student extends Person {
    // Private data member.
    private String status;

    // Getter and setter.
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Type: Student, " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + getEmail() + ", "
                + status;
    }
}