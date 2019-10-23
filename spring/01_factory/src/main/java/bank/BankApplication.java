package bank;

import bank.domain.Amount;
import bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
    private TransferService transferService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transferService.transferAmount(1L, 2L, new Amount(new BigDecimal(3000)));
    }
}
