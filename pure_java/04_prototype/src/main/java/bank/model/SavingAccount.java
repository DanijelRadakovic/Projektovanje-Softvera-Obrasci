package bank.model;

public class SavingAccount extends Account {

    private SavingTerms terms;

    public SavingAccount() {
    }

    public SavingAccount(String number, String currency, long balance, SavingTerms terms) {
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

    public SavingTerms getTerms() {
        return terms;
    }

    public void setTerms(SavingTerms terms) {
        this.terms = terms;
    }
}
