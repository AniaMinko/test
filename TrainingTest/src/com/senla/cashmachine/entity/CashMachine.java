package com.senla.cashmachine.entity;

public class CashMachine extends Entity{
    private Card card;
    private Client client;

    public CashMachine(Integer id, Card card, Client client) {
        super(id);
        this.card = card;
        this.client = client;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Machine{" + getId() + " " +
                "card=" + card +
                ", client=" + client +
                '}';
    }
}
