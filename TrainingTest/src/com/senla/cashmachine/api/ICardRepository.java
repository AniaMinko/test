package com.senla.cashmachine.api;

import com.senla.cashmachine.entity.Card;

import java.util.List;

public interface ICardRepository {

    List<Card> getCards();

    Card getCardByNumber(Integer number);

    Boolean addCard(Card card)throws Exception;

    Boolean deleteCard(Card card)throws Exception;

    Boolean submitApplication(Card card);


}
