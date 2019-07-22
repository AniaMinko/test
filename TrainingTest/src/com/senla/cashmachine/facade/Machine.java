package com.senla.cashmachine.facade;

import com.senla.cashmachine.api.ICashMashine;
import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.service.CardService;

public class Machine implements ICashMashine {

    private static Machine instance;
    private CardService cardService;

    public Machine() {
        cardService=new CardService();
    }

    public static Machine getInstance() {
        if(instance==null){
            instance=new Machine();
        }
        return instance;
    }
    public CardService getCardService() {
        return cardService;
    }


    @Override
    public void addCard(Card card) throws Exception {
        cardService.addCard(card);

    }

    @Override
    public void deleteCard(Card card) throws Exception {
        cardService.deleteCard(card);

    }

    @Override
    public void checkBalance(Card card) {
        cardService.checkBalance(card);

    }

    @Override
    public void addCash(Card card, Double money) {
        cardService.addCash(card,money);
    }

    @Override
    public void getCash(Card card, Double money) {
        cardService.getCash(card, money);

    }

    @Override
    public Boolean submitApplication(Card card) {
        return cardService.submitApplication(card);
    }
}
