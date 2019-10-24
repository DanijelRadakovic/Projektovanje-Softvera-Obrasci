package bank.service;

import bank.domain.Amount;

public interface TransferService {

    void transferAmount(Long a, Long b, Amount amount);
}
