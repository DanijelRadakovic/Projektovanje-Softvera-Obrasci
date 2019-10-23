package bank.service;

import bank.model.Account;
import bank.model.Amount;

public class MobilePaymentService implements MobilePaymentGateway {

    private PaymentGateway paymentGateway;

    public MobilePaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void doMobileTransaction(String device, Account account1, Account account2, Amount amount) {
        paymentGateway.doTransaction(account1,account2, amount);
        System.out.println("Sending notification to device: " + device);
    }
}
