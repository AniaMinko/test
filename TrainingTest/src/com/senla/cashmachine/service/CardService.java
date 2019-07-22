package com.senla.cashmachine.service;

import com.senla.cashmachine.api.ICardService;
import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.repository.CardRepository;

import java.util.List;

public class CardService implements ICardService {
    private CardRepository repository;

    public CardService(){
        this.repository=CardRepository.getInstance();
    }

    public CardRepository getRepository() {
        return repository;
    }

    @Override
    public List<Card> getCards() {
        return repository.getCards();
    }

    @Override
    public Card getCardByNumber(Integer number) {
       return repository.getCardByNumber(number);
    }

    @Override
    public Boolean addCard(Card card) throws Exception {
        return repository.addCard(card);
    }

    @Override
    public Boolean deleteCard(Card card) throws Exception {
        return repository.deleteCard(card);
    }

    @Override
    public Boolean submitApplication(Card card) {
        return repository.submitApplication(card);
    }

    @Override
    public Double checkBalance(Card card) {
        return repository.checkBalance(card);
    }

    @Override
    public Double addCash(Card card, Double money) {
        return repository.addCash(card,money);
    }

    @Override
    public Double getCash(Card card, Double money) {
        return repository.getCash(card,money);
    }
}
