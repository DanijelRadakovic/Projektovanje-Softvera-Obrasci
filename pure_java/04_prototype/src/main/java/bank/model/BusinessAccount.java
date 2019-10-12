package bank.model;

public class BusinessAccount extends Account {

    private BusinessTerms terms;

    public BusinessAccount() {
    }

    public BusinessAccount(String number, String currency, long balance, BusinessTerms terms) {
        this.number = number;
        this.currency = currency;
        this.balance = balance;
        this.terms = terms;
    }

    @Override
    public Account cloneAccount() {
        Account clone = null;
        try {
            /*
             super.clone() return shallow copy of object which means that they
             have same reference to terms object.

             clone.getTerms() == this.getTerms() --> true
            */
            clone = (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public BusinessTerms getTerms() {
        return terms;
    }

    public void setTerms(BusinessTerms terms) {
        this.terms = terms;
    }
}
