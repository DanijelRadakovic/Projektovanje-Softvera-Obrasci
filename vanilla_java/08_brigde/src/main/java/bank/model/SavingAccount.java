package bank.model;

public class SavingAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("OPENED SAVING ACCOUNT");
        return new SavingAccount();
    }

    @Override
    public void accountType() {
        System.out.println("SAVING ACCOUNT");
    }
}
