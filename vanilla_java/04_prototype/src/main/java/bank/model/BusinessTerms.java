package bank.model;

public class BusinessTerms implements Cloneable {

    private double maintenanceCosts;
    private double commissionFee;

    public BusinessTerms() {
    }

    public BusinessTerms(double maintenanceCosts, double commissionFee) {
        this.maintenanceCosts = maintenanceCosts;
        this.commissionFee = commissionFee;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double getMaintenanceCosts() {
        return maintenanceCosts;
    }

    public void setMaintenanceCosts(double maintenanceCosts) {
        this.maintenanceCosts = maintenanceCosts;
    }

    public double getCommissionFee() {
        return commissionFee;
    }

    public void setCommissionFee(double commissionFee) {
        this.commissionFee = commissionFee;
    }
}
