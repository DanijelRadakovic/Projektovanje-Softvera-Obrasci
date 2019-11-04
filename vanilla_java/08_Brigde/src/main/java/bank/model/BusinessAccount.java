package bank.model;

public class BusinessAccount implements Account {

    @Override
    public Account openAccount() {
        System.out.println("OPENED BUSINESS ACCOUNT");
        return new BusinessAccount();
    }

    @Override
    public void accountType() {
        System.out.println("BUSINESS ACCOUNT");
    }
}
