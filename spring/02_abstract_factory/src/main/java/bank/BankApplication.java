package bank;

import bank.domain.Amount;
import bank.factory.TransferServiceFactoryProvider;
import bank.repository.account.AccountRepository;
import bank.service.TransferService;
import bank.service.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootApplication
public class BankApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Autowired // auto-configured transferService
	private TransferService transferService;

	@Resource(name = "&jpaTransferService") // get reference to factory provider
	private TransferServiceFactoryProvider transferServiceFactoryProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		transferService.transferAmount(1L, 2L, new Amount(new BigDecimal(3000)));

		// manually configure TransferService
		transferServiceFactoryProvider.setFactoryType("jdbc");
		TransferService manuallyConfiguredTransferService = new TransferServiceImpl(
				transferServiceFactoryProvider.createInstance()
		);
		manuallyConfiguredTransferService.transferAmount(1L, 2L, new Amount(new BigDecimal(3000)));
	}
}
