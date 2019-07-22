package com.senla.cashmachine.main;

import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.entity.CashMachine;
import com.senla.cashmachine.entity.Client;
import com.senla.cashmachine.facade.Machine;
import com.senla.cashmachine.utils.FileWorker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static FileWorker fileWorker;

    public static void main(String[] args) throws Exception {
        fileWorker = new FileWorker("Cards.txt", "Machine.txt", "Clients.txt");

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1111, "Anna"));
        clients.add(new Client(1122, "Sasha"));
        clients.add(new Client(1133, "Kirill"));

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1100,111111111, 1111,100.0));
        cards.add(new Card(123,252525,1212,600.0));

        List<CashMachine> machines = new ArrayList<>();
        machines.add(new CashMachine(1,cards.get(0),clients.get(0)));
        machines.add(new CashMachine(11,cards.get(0),clients.get(1)));


        Machine cashMachine = new Machine();
        cashMachine.addCard(cards.get(0));
        cashMachine.addCard(cards.get(1));
        System.out.println("Your balance is: ");
        System.out.println(cashMachine.getCardService().checkBalance(cards.get(0)));
        //System.out.println(cashMachine.getCardService().addCash(cards.get(0),150.0));
        System.out.println("Balance replenished by 150.0");
        cashMachine.addCash(cards.get(0),150.0);
        System.out.println(cashMachine.getCardService().checkBalance(cards.get(0)));
        System.out.println("Withdrawn from the account 25.0");
        cashMachine.getCash(cards.get(0),25.0);
        System.out.println(cashMachine.getCardService().checkBalance(cards.get(0)));
        System.out.println(cashMachine.getCardService().getCards());

        fileWorker.writeCards(cashMachine.getCardService().getCards());
        fileWorker.writeClients(clients);
        fileWorker.writeMachines(machines);
        //fileWorker.readData();




    }

}
