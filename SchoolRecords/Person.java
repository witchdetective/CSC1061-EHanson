/**
 * This class is the parent class for all people.
 */
public class Person {
    /**  Private data members. */
    private String name;
    private String address;
    private String phone;
    private String email;

    
    /**
     * The getter for name. 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * The setter for name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * The getter for address.
     * @return String
     */
    public String getAddress() {
        return address;
    }

    
    /** 
     * The setter for address.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /** 
     * The getter for phone number.
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    
    /** 
     * The setter for phone number.
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    /** 
     * The getter for email.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * The setter for email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * The toString method.
     * @return String
     */
    public String toString() {
        return name + ", " + address + ", " + phone + ", " + email;
    }
}