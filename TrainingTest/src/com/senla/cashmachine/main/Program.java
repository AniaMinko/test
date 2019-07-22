package com.senla.cashmachine.main;

import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.entity.CashMachine;
import com.senla.cashmachine.entity.Client;
import com.senla.cashmachine.facade.Machine;
import com.senla.cashmachine.utils.FileWorker;

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

        List<CashMachine> machines = new ArrayList<>();
        machines.add(new CashMachine(1,cards.get(0),clients.get(0)));

        fileWorker.writeCards(cards);
        fileWorker.writeClients(clients);
        fileWorker.writeMachines(machines);

        Machine cashMachine = new Machine();
        cashMachine.addCard(new Card(123,252525,1212,600.0));
        System.out.println(cards.get(0).getBalance());
        cards.get(0).addCash(100.0);
        System.out.println(cards.get(0).getBalance());
        cards.get(0).getCash(50.0);
        System.out.println(cards.get(0).getBalance());






    }

}
