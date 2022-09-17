package ru.agentche.clients;

import ru.agentche.accounts.Account;
import ru.agentche.accounts.MoneyTarget;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 30.06.2022
 */
public class Client implements MoneyTarget {
    private final String name;
    private final Account[] accounts;

    public Client(String name, int maxBills) {
        this.name = name;
        accounts = new Account[maxBills];
    }

    public int add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return i;
            }
        }
        System.out.println("Превышен лимит открытия счетов!");
        return -1;
    }

    public boolean pay(int amount) {
        for (Account account : accounts) {
            if (account != null && account.pay(amount)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(int money) {
        for (Account account : accounts) {
            if (account != null && account.accept(money)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
