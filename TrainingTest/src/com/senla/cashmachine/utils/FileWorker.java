package com.senla.cashmachine.utils;
import com.danco.training.TextFileWorker;
import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.entity.Client;
import com.senla.cashmachine.entity.CashMachine;

import java.io.*;
import java.util.List;


public class FileWorker {

    private static TextFileWorker textFileWorker;
   // private static FileWriter textWriter;
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


    public void writeMachines(List<CashMachine> machines)throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(machinePath));
        for(CashMachine machine:machines){
            pw.println(machine);
        }
        pw.close();

    }
    public void writeCards(List<Card> cards) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(cardPath));
        for(Card card:cards){
            pw.println(card);
        }
        pw.close();
    }

    public void writeClients(List<Client> clients) throws IOException {
            PrintWriter pw = new PrintWriter(new FileOutputStream(clientPath));
            for(Client client:clients){
                pw.println(client);
    }
        pw.close();}

    public void readData() {
        BufferedReader br=null;
        try{
            br= new BufferedReader(new FileReader(machinePath));
            String line;
             while((line=br.readLine())!=null){
                 System.out.println(line);
             }

        }
        catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
