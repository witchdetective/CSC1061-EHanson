public class TestAccount {
    public static void main(String[] args) {
        Account myAccount = new Account(0, 0);
        myAccount.setId(1122);
        myAccount.setBalance(50.00);
        myAccount.setAnnualInterestRate(4.5);
        myAccount.withdraw(2500.00);
        myAccount.deposit(3000);
        System.out.println("ID: " + myAccount.getId() + "\nDate account was create: " +
                myAccount.getDateCreated() + "\nBalance: " + myAccount.getBalance() + "\nMonthly interest: "
                + myAccount.getMonthlyInterest());

        CheckingAccount myCheckingAccount = new CheckingAccount();
        myCheckingAccount.setAnnualInterestRate(1.5);
        myCheckingAccount.setName("George");
        myCheckingAccount.deposit(30.00);
        myCheckingAccount.deposit(40.00);
        myCheckingAccount.deposit(50.00);
        myCheckingAccount.withdraw(5.00);
        myCheckingAccount.withdraw(4.00);
        myCheckingAccount.withdraw(2.00);

System.out.println("ID: " + myCheckingAccount.getId() + "\nDate account was create: " +
                myCheckingAccount.getDateCreated() + "\nBalance: " + "\nName: " + myCheckingAccount.getName() + myCheckingAccount.getBalance() + "\nMonthly interest: "
                + myCheckingAccount.getMonthlyInterest());
    }
}