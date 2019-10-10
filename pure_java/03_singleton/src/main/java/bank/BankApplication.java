package bank;

public class BankApplication {

    public static void main(String[] args) {
        System.out.println(DataBaseConnection.getInstance().getClass().getCanonicalName());
        System.out.println(SSHConnection.getInstance().getClass().getCanonicalName());
    }
}
