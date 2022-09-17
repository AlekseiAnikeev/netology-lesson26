package ru.agentche;

import ru.agentche.accounts.Account;
import ru.agentche.accounts.CheckingAccount;
import ru.agentche.accounts.CreditAccount;
import ru.agentche.accounts.SavingsAccount;
import ru.agentche.clients.Client;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 30.06.2022
 */
public class Main {
    public static void main(String[] args) {
        Account[] account;
        Client clientNikolay = new Client("Николай", 3);
        clientNikolay.add(new SavingsAccount(clientNikolay.getName(), 10000, 0));
        clientNikolay.add(new CreditAccount(clientNikolay.getName(), -500));
        clientNikolay.add(new CheckingAccount(clientNikolay.getName(), 1500));

        checkBalanceInAccount(clientNikolay);
        account = clientNikolay.getAccounts();
        System.out.println(account[2].transfer(account[1], 10000));
        checkBalanceInAccount(clientNikolay);
        System.out.println(account[0].transfer(account[1], 10000));
        checkBalanceInAccount(clientNikolay);
        System.out.println(account[1].transfer(account[2], 10000));
        checkBalanceInAccount(clientNikolay);
        System.out.println(account[2].transfer(account[1], 200));
        checkBalanceInAccount(clientNikolay);
        System.out.println(account[1].transfer(account[2], 500));
        checkBalanceInAccount(clientNikolay);

        for (int i = 0; i < 10; i++) {
            if (clientNikolay.accept(300000)) {
                System.out.println("Успешное пополнение счета");
            } else {
                System.out.println("Операция прервана");
            }
        }
        checkBalanceInAccount(clientNikolay);

        System.out.println("\n\nДобавляем клиента");
        Client clientAlexey = new Client("Алексей", 5);
        clientAlexey.add(new CreditAccount(clientAlexey.getName(), -1000));
        for (int i = 0; i < 5; i++) {
            if (clientAlexey.accept(270)) {
                System.out.println("Успешное пополнение счета");
            } else {
                System.out.println("Операция прервана");
            }
        }
        checkBalanceInAccount(clientAlexey);
    }

    public static void checkBalanceInAccount(Client clientNikolay) {
        for (Account account : clientNikolay.getAccounts()) {
            System.out.println(account);
        }
        System.out.println();
    }
}
