package com.senla.cashmachine.utils;

import com.senla.cashmachine.entity.*;

public class Parser {

    public static Card parseCard(String line) {
        String[] cardString = line.split(" ");
        Integer id = Integer.parseInt(cardString[0]);
        Integer cardNumber =Integer.parseInt(cardString[1]);
        Integer pinCode = Integer.parseInt(cardString[2]);
        Double balance = Double.parseDouble(cardString[3]);
        return new Card(id, cardNumber, pinCode, balance);
    }

    public static Client parseClient(String line) {
        String[] clientString = line.split(" ");
        Integer id = Integer.parseInt(clientString[0]);
        String name = clientString[1];
        return new Client(id, name);
    }

    public static CashMachine parseMachine(String line) {
        String[] machineString = line.split(" ");
        Integer id = Integer.parseInt(machineString[0]);
        Card card = new Card(Integer.parseInt(machineString[1]), Integer.parseInt(machineString[2]), Integer.parseInt(machineString[3]),
                Double.parseDouble(machineString[4]));
        Client client = new Client(Integer.parseInt(machineString[5]), machineString[6]);
        return new CashMachine(id, card,client);
    }
}
