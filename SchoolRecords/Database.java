import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    
    static final File MY_FILE = new File("PersonDatabase.txt"); // Constant file.


    public Database() { // Checks for file.
        if (!MY_FILE.exists()) {
            try {
                if (MY_FILE.createNewFile()) {
                    System.out.println("New file created: " + MY_FILE.getName());
                }
            } catch (IOException e) {
                System.out.print(e.getMessage());
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public ArrayList<Person> readDatabase() { // Reads file and returns list of each string after a comma and space.
        ArrayList<Person> people = new ArrayList<Person>();

        Scanner s = null;
        try {
            s = new Scanner(MY_FILE);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] tokens = line.split(", ");

                // Checks for each type of person/employee.
                if (tokens[0].equals("Type: Student")) {
                    Student student = new Student();
                    student.setName(tokens[1]);
                    student.setAddress(tokens[2]);
                    student.setPhone(tokens[3]);
                    student.setEmail(tokens[4]);
                    student.setStatus(tokens[5]);
                    people.add(student);
                } if(tokens[0].equals("Type: Faculty")) {
                    Faculty faculty = new Faculty();
                    faculty.setName(tokens[1]);
                    faculty.setAddress(tokens[2]);
                    faculty.setPhone(tokens[3]);
                    faculty.setEmail(tokens[4]);
                    faculty.setOffice(tokens[5]);
                    faculty.setSalary(Double.parseDouble(tokens[6]));
                    faculty.setDate(tokens[7]);
                    faculty.setHours(Integer.parseInt(tokens[8]));
                    faculty.setRank(tokens[9]);
                    people.add(faculty);
                } if(tokens[0].equals("Type: Staff")) {
                    Staff staff = new Staff();
                    staff.setName(tokens[1]);
                    staff.setAddress(tokens[2]);
                    staff.setPhone(tokens[3]);
                    staff.setEmail(tokens[4]);
                    staff.setOffice(tokens[5]);
                    staff.setSalary(Double.parseDouble(tokens[6]));
                    staff.setDate(tokens[7]);
                    staff.setTitle(tokens[8]);
                    people.add(staff);
                }
            }
            s.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            System.exit(-1);
        }

        return people;
    }

    public void writePerson(Object Person) { // Writes to file.

        try {

            PrintWriter print = new PrintWriter(new FileOutputStream(MY_FILE, true));

            print.println(Person.toString());
            if (print.checkError()) {
                System.out.println("There were errors in writing the file");
            }
            print.close();

        } catch (IOException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();

        }
    }

}