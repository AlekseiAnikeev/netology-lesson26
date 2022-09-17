package ru.agentche.accounts;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 28.06.2022
 */
public class CheckingAccount extends Account {
    public CheckingAccount(String name, long balance) {
        super(name, balance);
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (getBalance() - amount >= 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Накопительный счет {" +
                "Владелец = '" + name + '\'' +
                ", баланс = " + balance +
                '}';
    }
}
