package com.senla.cashmachine.utils;
import com.danco.training.TextFileWorker;
import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.entity.Client;
import com.senla.cashmachine.entity.CashMachine;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {

    private static TextFileWorker textFileWorker;
    public final String cardPath = "src/Cards.txt";
    private final String clientPath = "src/Clients.txt";
    private final String machinePath = "src/Machine.txt";
    private String pathOfCard;
    private String pathOfMachine;
    private String pathOfClient;

    public FileWorker(String pathOfCard, String pathOfMachine, String pathOfClient) {
        if(pathOfCard!=null && pathOfMachine!=null && pathOfClient!=null){
        this.pathOfCard = pathOfCard;
        this.pathOfMachine = pathOfMachine;
        this.pathOfClient = pathOfClient;
        }
        else{
            this.pathOfCard= cardPath;
            this.pathOfMachine=machinePath;
            this.pathOfClient=clientPath;
        }
    }
    public void writeCards(List<Card> cards) {
        textFileWorker = new TextFileWorker(this.pathOfCard);
        String[] cardsLine = new String[cards.size()];
        for (int i = 0; i < cards.size(); i++) {

                cardsLine[i] = cards.get(i).toString();
            textFileWorker.writeToFile(cardsLine);
            }
        }

    public void writeClients(List<Client> clients){
        textFileWorker = new TextFileWorker(this.pathOfClient);
        String[] clientsLine = new String[clients.size()];
        for (int i = 0; i < clients.size(); i++) {

            clientsLine[i] = clients.get(i).toString();

        }
        textFileWorker.writeToFile(clientsLine);

    }
    public void writeMachines(List<CashMachine> machines){
        textFileWorker = new TextFileWorker(this.pathOfMachine);
        String[] machinesLine = new String[machines.size()];
        for (int i = 0; i < machines.size(); i++) {

            machinesLine[i] = machines.get(i).toString();
        }
        textFileWorker.writeToFile(machinesLine);
    }

    public List<Card> readCards() throws ParseException {
        textFileWorker = new TextFileWorker(this.pathOfCard);
        String[] cardsLine = textFileWorker.readFromFile();
        List<Card> cards = new ArrayList<>();
            for (int i = 0; i < cardsLine.length; i++) {
                cards.add(Parser.parseCard(cardsLine[i]));
            }
            return cards;
    }

    public List<Client> readClients(){
        textFileWorker = new TextFileWorker(this.pathOfClient);
        String[] clientsLine = textFileWorker.readFromFile();
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < clientsLine.length; i++) {
            clients.add(Parser.parseClient(clientsLine[i]));
        }
        return clients;
    }

    public List<CashMachine> readData(){
        textFileWorker = new TextFileWorker(this.pathOfMachine);
        String[] dataLine = textFileWorker.readFromFile();
        List<CashMachine> machines = new ArrayList<>();
        for (int i = 0; i < dataLine.length; i++) {
            machines.add(Parser.parseMachine(dataLine[i]));
        }
        return machines;
    }
}
