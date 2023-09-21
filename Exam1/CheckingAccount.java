public class CheckingAccount extends Account {
    private double overDraftLimit = 5000;
    private double annualInterestRate;


    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    

    public CheckingAccount() {

    }

    public CheckingAccount(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverDraftLimit() {
        return this.overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }



    @Override
    public String toString() {
        return "{" +
            " overDraftLimit='" + getOverDraftLimit() + "'" +
            "}";
    }

}