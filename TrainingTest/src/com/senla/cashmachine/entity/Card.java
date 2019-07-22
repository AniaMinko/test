package com.senla.cashmachine.entity;

import java.util.Objects;

public class Card extends Entity{
    private Integer cardNumber;
    private Integer pinCode;
    private Double balance;

    public Card(Integer id ,Integer cardNumber, Integer pinCode, Double balance) {
        super(id);
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Double addCash(Double money){
        if(money<=1000000){
        this.balance+=money;}
        else {
            System.out.println("Incorrect data.");
        }
        return money;
    }
    public Double getCash(Double money){
        if(balance>money){
            balance-=money;
        }
            return money;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber) &&
                Objects.equals(pinCode, card.pinCode) &&
                Objects.equals(balance, card.balance);
    }


    @Override
    public String toString() {
        return "Card{" + getId() + " " +
                "cardNumber=" + cardNumber +
                ", pinCode=" + pinCode +
                ", balance=" + balance +
                '}';
    }
}


