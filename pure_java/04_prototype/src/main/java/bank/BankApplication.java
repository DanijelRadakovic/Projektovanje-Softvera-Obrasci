package bank;

import bank.model.Account;
import bank.repository.AccountRepository;

public class BankApplication {

    public static void main(String[] args) {
        final String SAVING_ACCOUNT_NUMBER = "170-845130017-56";
        final String BUSINESS_ACCOUNT_NUMBER = "170-243525111-42";
        AccountRepository repository = new AccountRepository();

        System.out.println("Saving Balance: " + repository.get(SAVING_ACCOUNT_NUMBER).getBalance());

        Account businessAcc = repository.get(BUSINESS_ACCOUNT_NUMBER);
        System.out.println("Business Balance: " + repository.get(BUSINESS_ACCOUNT_NUMBER).getBalance());

        businessAcc.setBalance(10000L);
        repository.save(businessAcc);
        System.out.println("Business Balance: " + repository.get(BUSINESS_ACCOUNT_NUMBER).getBalance());
    }
}
