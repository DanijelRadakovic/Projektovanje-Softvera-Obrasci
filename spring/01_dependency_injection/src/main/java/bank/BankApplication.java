package bank;

import bank.config.AppConfig;
import bank.model.Amount;
import bank.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class BankApplication {

    public static void main(String[] args) {
        TransferService transferService;
        Long georgeId, coreyId;
        Amount amount;

        georgeId = 1L; coreyId = 2L;
        amount = new Amount(new BigDecimal(2000));

        //Load Spring context
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //Get TransferService bean
        transferService = applicationContext.getBean(TransferService.class);

        transferService.transferAmount(georgeId, coreyId, amount);
        applicationContext.close();
    }
}
