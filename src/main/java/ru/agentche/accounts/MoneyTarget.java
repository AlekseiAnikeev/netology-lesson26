package ru.agentche.accounts;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 06.07.2022
 */
public interface MoneyTarget {
    boolean accept(int money);
}
