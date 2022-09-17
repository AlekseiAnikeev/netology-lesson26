package ru.agentche.accounts;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 28.06.2022
 */
public class CreditAccount extends Account {
    public CreditAccount(String name, long balance) {
        super(name, balance);
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount < 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Кредитный счет {" +
                "Владелец = '" + name + '\'' +
                ", баланс = " + balance +
                '}';
    }
}
