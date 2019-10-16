package bank.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("savingAccount")
@Scope("prototype")
@Qualifier("savingAccount")
public class SavingAccount extends Account {

    private SavingTerms terms;

    public SavingAccount() {
    }

    public SavingAccount(String number, String currency, long balance, SavingTerms terms) {
        super(number, currency, balance);
        this.terms = terms;
    }

    public SavingAccount(Account account) throws ClassCastException {
        super(account.number, account.currency, account.balance);
        this.terms = new SavingTerms(((SavingAccount) account).getTerms());
    }

    @Override
    public String getPrototypeBeanName() {
        return "savingAccountPrototype";
    }

    @Bean("savingAccountPrototype")
    @Scope("prototype")
    @Qualifier("savingAccountPrototype")
    public static SavingAccount clone(SavingAccount account) {
        return new SavingAccount(account);
    }

    public SavingTerms getTerms() {
        return terms;
    }

    public void setTerms(SavingTerms terms) {
        this.terms = terms;
    }
}
