package bank.service;

import bank.model.Amount;

public interface TransferService {

    void transferAmount(Long a, Long b, Amount amount);
}
