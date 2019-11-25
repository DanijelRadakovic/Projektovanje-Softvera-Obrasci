package bank.model;

public class BritishBank extends Bank {

    public BritishBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("Opening account at British Bank");
        return account;
    }
}
