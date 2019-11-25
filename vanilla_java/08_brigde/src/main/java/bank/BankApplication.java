package bank;

import bank.model.*;

public class BankApplication {

    public static void main(String[] args) {
        new IrishBank(new SavingAccount())
                .openAccount()
                .accountType();

        new BritishBank(new BusinessAccount())
                .openAccount()
                .accountType();
    }
}
