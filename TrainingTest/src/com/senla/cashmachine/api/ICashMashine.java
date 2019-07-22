package com.senla.cashmachine.api;

import com.senla.cashmachine.entity.Card;

public interface ICashMashine {

    void addCard(Card card) throws Exception;
    void deleteCard(Card card) throws Exception;
    void checkBalance(Card card);
    void addCash(Card card, Double money);
    void getCash(Card card, Double money);
    Boolean submitApplication(Card card);
}
