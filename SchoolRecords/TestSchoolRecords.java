import java.util.ArrayList; // For Arraylists.
/**
 * This class tests the code.
 * @author Emma
 */
public class TestSchoolRecords { 
/** 
 * This is the main method to test all classes. It create 6 people and creates an ArrayList for each.
 * @param args
 */
    public static void main(String[] args) {
        Database data = new Database();
        
        Student student1 = new Student();
        student1.setName("Sharon Wolf");
        student1.setAddress("123 Fake St.");
        student1.setPhone("(302)324-2149");
        student1.setEmail("notanemail@yahoo.com");
        student1.setStatus("Junior");
        data.writePerson(student1);

        Student student2 = new Student();
        student2.setName("Conrad Lindsey");
        student2.setAddress("456 Not Real Way");
        student2.setPhone("(221)405-2941");
        student2.setEmail("fake@email.net");
        student2.setStatus("Senior");
        data.writePerson(student2);

        Faculty faculty1 = new Faculty();
        faculty1.setName("Sam Smith");
        faculty1.setAddress("1234 Farse Ct.");
        faculty1.setPhone("(124)543-1344");
        faculty1.setEmail("email@notreal.net");
        faculty1.setOffice("Office Name");
        faculty1.setSalary(2300.00);
        faculty1.setDate("9/4/2009");
        faculty1.setHours(8);
        faculty1.setRank("Senior");
        data.writePerson(faculty1);

        Faculty faculty2 = new Faculty();
        faculty2.setName("Bobby Thompson");
        faculty2.setAddress("9872 Never Existed St");
        faculty2.setPhone("(201)639-0294");
        faculty2.setEmail("emailname@gmail.com");
        faculty2.setOffice("Office That Doesn't Exist");
        faculty2.setSalary(2200.00);
        faculty2.setHours(8);
        faculty2.setDate("9/2/2012");
        faculty2.setRank("Junior");
        data.writePerson(faculty2);

        Staff staff1 = new Staff();
        staff1.setName("Stan Harris");
        staff1.setAddress("9872 Never Existed St");
        staff1.setPhone("(201)639-0294");
        staff1.setEmail("emailname@gmail.com");
        staff1.setOffice("Fake Office");
        staff1.setSalary(800.00);
        staff1.setDate("9/1/2011");
        staff1.setTitle("Janitor");
        data.writePerson(staff1);

        Staff staff2 = new Staff();
        staff2.setName("Ryan Marsh");
        staff2.setAddress("9872 Never Existed St");
        staff2.setPhone("(892)104-3420");
        staff2.setEmail("nooneknows@gmail.com");
        staff2.setOffice("Another Office");
        staff2.setSalary(2000.00);
        staff2.setDate("9/5/2014");
        staff2.setTitle("Math Teacher");
        data.writePerson(staff2);

        ArrayList<Person> people = data.readDatabase();

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}