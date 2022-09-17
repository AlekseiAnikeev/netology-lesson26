package ru.agentche.accounts;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 28.06.2022
 */
public abstract class Account implements MoneyTarget {
    protected String name;
    protected long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);

    public boolean transfer(Account accountTo, int amount) {
        if (pay(amount)) {
            if (accountTo.add(amount)) {
                return true;
            } else {
                add(amount);
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean accept(int money) {
        return add(money);
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

}
