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

                double paymentAmount = weeklySalary;
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

                    double comPaymentAmount = ((CommissionEmployee) payableEmployees[i]).getPaymentAmount();

                    System.out.println("What is your base pay?");
                    double basePay = s.nextDouble();
                    ((BasePlusCommissionEmployee) payableEmployees[i]).setBasePay(basePay);

                    double basePlusComPaymentAmount = ((BasePlusCommissionEmployee) payableEmployees[i])
                            .getPaymentAmount();

                    basePlusComPaymentAmount = basePlusComPaymentAmount + (basePlusComPaymentAmount * 0.1); // Increases 10% to the base salary.

                    double paymentAmount = basePlusComPaymentAmount + comPaymentAmount;

                } else {
                    payableEmployees[i] = new CommissionEmployee();
                    getEmployeeInfo(payableEmployees[i], s);

                    System.out.println("What is your gross sales amount?");
                    double grossSales = s.nextDouble();
                    ((CommissionEmployee) payableEmployees[i]).setGrossSales(grossSales);

                    System.out.println("What is your commision rate?");
                    int commisionRate = s.nextInt();
                    ((CommissionEmployee) payableEmployees[i]).setCommisionRate(commisionRate);

                    double comPaymentAmount = ((CommissionEmployee) payableEmployees[i]).getPaymentAmount();

                    double paymentAmount = comPaymentAmount;

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

                double hourlyPaymentAmount = ((HourlyEmployee) payableEmployees[i]).getPaymentAmount();

                double paymentAmount = hourlyPaymentAmount;
            }

            if (payableEmployees[i] != null) { // Makes sure the program prints information when the user mistypes.
                print(i, payableEmployees);
                printWithoutToString(i, payableEmployees);
            }
        }
        s.close();

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
    public static void print(int i, Employee payableEmployees[]) {
        System.out.println(payableEmployees[i].toString());
    }
    // Prints without toString.
    public static void printWithoutToString(int i, Employee payableEmployees[]) {
        System.out.println(payableEmployees[i].getFirstName() + ", " + payableEmployees[i].getLastName() + ", "
                + payableEmployees[i].getSocial() + ", " + payableEmployees[i].getPaymentAmount());
    }
}