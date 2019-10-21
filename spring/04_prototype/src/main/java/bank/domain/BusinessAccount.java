package bank.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Primary
@Component("businessAccount")
@Scope("prototype")
public class BusinessAccount extends Account {

    private BusinessTerms terms;

    public BusinessAccount() {
    }

    public BusinessAccount(String number, String currency, long balance, BusinessTerms terms) {
        super(number, currency, balance);
        this.terms = terms;
    }

    public BusinessAccount(BusinessAccount account) {
        super(account.number, account.currency, account.balance);
        this.terms = new BusinessTerms(account.terms);
    }

    @Override
    public String getPrototypeBeanName() {
        return "businessAccountPrototype";
    }

    @Bean("businessAccountPrototype")
    @Scope("prototype")
    public static BusinessAccount clone(BusinessAccount account) {
        return new BusinessAccount(account);
    }

    public BusinessTerms getTerms() {
        return terms;
    }

    public void setTerms(BusinessTerms terms) {
        this.terms = terms;
    }
}
