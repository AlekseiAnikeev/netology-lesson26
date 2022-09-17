package ru.agentche.clients;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.agentche.accounts.CreditAccount;
import ru.agentche.accounts.SavingsAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 17.09.2022
 */
public class ClientTest {

    @Test
    @DisplayName("Лимит счетов")
    void shouldHaveAnAccountLimit() {
        Client ivan = new Client("Ivan", 0);
        SavingsAccount savingsAccount = new SavingsAccount(ivan.getName(), 10000, 0);
        assertEquals(-1, ivan.add(savingsAccount));
    }

    @Test
    @DisplayName("Проверка пополнения кредитного счета")
    void shouldNotBeReplenished() {
        Client ivan = new Client("Ivan", 1);
        CreditAccount creditAccount = new CreditAccount(ivan.getName(), -1);
        ivan.add(creditAccount);
        assertFalse(ivan.accept(200));
    }

    @Test
    @DisplayName("Возможность оплаты превышающей баланс")
    void shouldNotBePaid() {
        Client ivan = new Client("Ivan", 1);
        ivan.add(new SavingsAccount(ivan.getName(), 10000, 0));
        assertFalse(ivan.pay(20000));
    }
}
