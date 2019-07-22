package com.senla.cashmachine.repository;

import com.senla.cashmachine.api.ICardRepository;
import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.utils.FileWorker;

import java.util.ArrayList;
import java.util.List;

public class CardRepository implements ICardRepository {
    private static CardRepository instance;
    private List<Card> cards;
    private FileWorker fileWorker;

    public CardRepository() {

        cards= new ArrayList<>();
    }
    public static CardRepository getInstance() {
        if (instance == null) {
            instance = new CardRepository();
        }
        return instance;
    }
    public List<Card> getCards() {
        return cards;

    }

    @Override
    public Card getCardByNumber(Integer number) {
        return cards.get(number);
    }

    @Override
    public Boolean addCard(Card card) throws Exception {
        try {
            Boolean temp = cards.add(card);
            fileWorker.writeCards(cards);
            return temp;
        } catch (NullPointerException e) {
           // log.error(e);
        }
        return null;
    }

    public Double checkBalance(Card card){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) != null && cards.get(i).equals(card)) {
                return cards.get(i).getBalance();
            }
        }
        return null;
    }
    public  Double addCash(Card card, Double money){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) != null && cards.get(i).equals(card)) {
                return cards.get(i).addCash(money);
            }
        }
        return null;
    }

    public  Double getCash(Card card, Double money){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) != null && cards.get(i).equals(card)) {
                return cards.get(i).getCash(money);
            }
        }
        return null;
    }

    @Override
    public Boolean deleteCard(Card card) throws Exception {
        try {
            Boolean temp = cards.remove((Card) card);

            return temp;
        } catch (NullPointerException e) {
            //log.error(e);
        }
        return null;
    }

    @Override
    public Boolean submitApplication(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) != null && cards.get(i).getCardNumber()==card.getCardNumber() && cards.get(i).getId() == card.getId()&& cards.get(i).getPinCode()==card.getPinCode()) {
                return true;
            } else {
                return false;
            }
        }
        return null;
    }


}
