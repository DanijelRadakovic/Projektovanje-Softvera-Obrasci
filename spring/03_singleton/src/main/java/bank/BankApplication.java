package bank;

import bank.connection.DatabaseConnection;
import bank.connection.SSHConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
	private DatabaseConnection databaseConnection1;

    @Autowired
	private DatabaseConnection databaseConnection2;

    @Autowired
	private SSHConnection sshConnection1;

    @Autowired
	private SSHConnection sshConnection2;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(databaseConnection1 == databaseConnection2); // same objects
		System.out.println(sshConnection1 == sshConnection2); // same objects
	}
}
