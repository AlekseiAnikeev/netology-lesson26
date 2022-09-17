package ru.agentche.accounts;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 28.06.2022
 */
public class SavingsAccount extends Account {
    private final long MIN_BALANCE;

    public SavingsAccount(String name, long balance, long MIN_BALANCE) {
        super(name, balance);
        this.MIN_BALANCE = MIN_BALANCE;
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (getBalance() - amount >= MIN_BALANCE) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Сберегательный счет {" +
                "Владелец = '" + name + '\'' +
                ", баланс = " + balance +
                '}';
    }
}
