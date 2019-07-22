package com.senla.cashmachine.api;

import com.senla.cashmachine.entity.Card;

import java.util.List;

public interface ICardService {

    List<Card> getCards();

    Card getCardByNumber(Integer number);

    Boolean addCard(Card card)throws Exception;

    Boolean deleteCard(Card card)throws Exception;

    Boolean submitApplication(Card card);

    Double checkBalance (Card card);

    Double addCash (Card card, Double money);

    Double getCash (Card card, Double money);


}
