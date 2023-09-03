import java.util.Scanner; // Scanner object.

public class AccountsPayable { // Begin driver class.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Employee[] payableEmployees = new Employee[6];

        for (int i = 0; i < payableEmployees.length; i++) { // For prompting the user information about each employee.

            System.out.println("What kind of employee are you? Salaried, Commision, or Hourly?");
            String typeOfEmployee = s.next();
            s.nextLine();

            if (typeOfEmployee.equals("Salaried")) {
                payableEmployees[i] = new SalariedEmployee();
                getEmployeeInfo(payableEmployees[i], s);

                System.out.println("What is your weekly salary?");
                double weeklySalary = s.nextDouble();
                ((SalariedEmployee) payableEmployees[i]).setWeeklySalary(weeklySalary);
            }
            if (typeOfEmployee.equals("Commision")) {
                System.out.println("Do you have the base plus commision?");
                String bonus = s.nextLine();
                if (bonus.equals("Yes")) {
                    payableEmployees[i] = new BasePlusCommissionEmployee();

                    getEmployeeInfo(payableEmployees[i], s);

                    System.out.println("What is your gross sales amount?");
                    double grossSales = s.nextDouble();
                    ((CommissionEmployee) payableEmployees[i]).setGrossSales(grossSales);

                    System.out.println("What is your commision rate?");
                    int commisionRate = s.nextInt();
                    ((CommissionEmployee) payableEmployees[i]).setCommisionRate(commisionRate);

                    System.out.println("What is your base pay?");
                    double basePay = s.nextDouble();
                    // ((BasePlusCommissionEmployee) payableEmployees[i]).setBasePay(basePay);

                    basePay = basePay + (basePay * 0.1); // Increases 10% to the base salary.

                    ((BasePlusCommissionEmployee) payableEmployees[i]).setBasePay(basePay);
                } else {
                    payableEmployees[i] = new CommissionEmployee();
                    getEmployeeInfo(payableEmployees[i], s);

                    System.out.println("What is your gross sales amount?");
                    double grossSales = s.nextDouble();
                    ((CommissionEmployee) payableEmployees[i]).setGrossSales(grossSales);

                    System.out.println("What is your commision rate?");
                    int commisionRate = s.nextInt();
                    ((CommissionEmployee) payableEmployees[i]).setCommisionRate(commisionRate);

                }
            }
            if (typeOfEmployee.equals("Hourly")) {
                payableEmployees[i] = new HourlyEmployee();

                getEmployeeInfo(payableEmployees[i], s);
                System.out.println("What is your hourly wage?");
                double hourlyWage = s.nextDouble();
                ((HourlyEmployee) payableEmployees[i]).setHourlyWage(hourlyWage);

                System.out.println("What are your hours?");
                int hours = s.nextInt();
                ((HourlyEmployee) payableEmployees[i]).setHours(hours);

            }
        }
        s.close();

        for (int i = 0; i < payableEmployees.length; i++) {
            if (payableEmployees[i] != null) {
                print(payableEmployees[i]);
                printWithoutToString(i, payableEmployees);
            }
        }
    }

    public static void getEmployeeInfo(Employee payableEmployees, Scanner s) {
        System.out.println("What is the first employee's first name?");
        String firstName = s.nextLine();
        payableEmployees.setFirstName(firstName);

        System.out.println("What is the first employee's last name?");
        String lastName = s.nextLine();
        payableEmployees.setLastName(lastName);

        System.out.println("What is the first employee's social security number?");
        int social = s.nextInt();
        payableEmployees.setSocial(social);
    }

    // Prints with toString.
    public static void print(Employee payableEmployees) {
        System.out.println(payableEmployees.toString());
    }

    // Prints without toString.
    public static void printWithoutToString(int i, Employee payableEmployees[]) {
        System.out.println(payableEmployees[i].getFirstName() + "\n" + payableEmployees[i].getLastName() + "\n"
                 + payableEmployees[i].getPaymentAmount());
    }
}