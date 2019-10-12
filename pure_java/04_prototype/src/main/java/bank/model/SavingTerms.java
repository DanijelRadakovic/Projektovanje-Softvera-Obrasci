package bank.model;

public class SavingTerms {

    private int period;
    private double interestRate;

    public SavingTerms() {
    }

    public SavingTerms(int period, double interestRate) {
        this.period = period;
        this.interestRate = interestRate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
