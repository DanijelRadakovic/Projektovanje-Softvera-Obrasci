package bank.repository;

import bank.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class AccountRepository {

    @Autowired
    private ApplicationContext appContext;

    // cache frequently used accounts
    private static final Map<String, Account> cache = new HashMap<>();

    // initialize frequently used accounts
    static {
        cache.put("170-845130017-56", new SavingAccount(
                "170-845130017-56",
                "EUR",
                2000L,
                new SavingTerms(12, 5)
        ));
        cache.put("170-147325493-42", new BusinessAccount(
                "170-147325493-42",
                "USD",
                5000L,
                new BusinessTerms(300, 10)
        ));
    }

    public Account get(String accountNumber) {
        /*
        if account is not cached, fetch account from database
        and cache fetched account
         */
        cache.computeIfAbsent(accountNumber, s -> {
            try {
                System.out.println("Fetching account from database");
                Thread.sleep(5000L); // very long action
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return generateRandomAccount(accountNumber); // caching fetched account
        });
        // return cloned account
        return (Account) appContext.getBean(
                cache.get(accountNumber).getPrototypeBeanName(),
                cache.get(accountNumber)
        );
    }

    public void save(Account account) {
        try {
            System.out.println("Saving account to database");
            Thread.sleep(5000L); // very long action
            cache.put(account.getNumber(), account); // update cache
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Account generateRandomAccount(String accountNumber) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextBoolean()) {
            return new SavingAccount(
                    accountNumber,
                    "EUR",
                    random.nextLong(),
                    new SavingTerms(random.nextInt(99), random.nextDouble())
            );
        } else {
            return new BusinessAccount(
                    accountNumber,
                    "EUR",
                    random.nextLong(),
                    new BusinessTerms(random.nextDouble(), random.nextDouble())
            );
        }
    }
}
