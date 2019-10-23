package bank;

import bank.model.Account;
import bank.model.Amount;
import bank.service.MobilePaymentGateway;
import bank.service.MobilePaymentService;
import bank.service.PaymentService;

public class BankApplication {

    public static void main(String[] args) {

        Account from, to;
        Amount amount;
        String device;
        MobilePaymentGateway paymentService;

        from = new Account("123-7569842315-43", 3000);
        to = new Account("789-8563421567-72", 5000);
        amount = new Amount(2000);
        device = "Librem 5";

        paymentService = new MobilePaymentService(new PaymentService());
        paymentService.doMobileTransaction(device, from, to, amount);
    }
}
