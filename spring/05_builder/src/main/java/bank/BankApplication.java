package bank;

import bank.config.SSHConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Autowired
	@Qualifier("connection1")
	private SSHConnection connection1;

	@Autowired
	@Qualifier("connection2")
	private SSHConnection connection2;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// @Singular annotation crates immutable collection
		try {
			connection1.getNodes().add("workstation2");
		} catch (UnsupportedOperationException e) {
			System.out.println("Collections in connection1 are immutable!");
		}

		try {
			connection2.getKnownHosts().clear();
		} catch (UnsupportedOperationException e) {
			System.out.println("Collections in connection2 are immutable!");
		}
	}
}
