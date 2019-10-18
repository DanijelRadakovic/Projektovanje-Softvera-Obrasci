package bank.model;

public class Account {

    private Long accountId;
    private String name;
    private Amount amount;

    public Account(Long accountId, String name, Amount amount) {
        this.accountId = accountId;
        this.name = name;
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
