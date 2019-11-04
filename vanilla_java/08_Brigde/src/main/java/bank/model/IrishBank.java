package bank.model;

public class IrishBank extends Bank {

    public IrishBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("Opening account at Irish Bank");
        return account;
    }
}
