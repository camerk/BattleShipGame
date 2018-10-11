package com.BSG.Comms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Spooling up Server...");
        Server server = new Server(3333);
        server.execute();
        System.out.println("Server is up.");
        //System.out.println("Spooling up Player 1...");
        Client Player1 = new Client("localhost", 3333);
        Player1.execute();
        //System.out.println("Player 1 is up.");
        //System.out.println("Spooling up Player 2...");
        Client Player2 = new Client("localhost", 3333);
        Player2.execute();
        //System.out.println("Player 2 is up.");

        //System.out.println("FLAG 1");
        //Player1.outboxAddMsg("Hello from player1");
        //System.out.println("FLAG 2");
        //Player2.outboxAddMsg("Hello from player2");
        //System.out.println("FLAG 3");
        //System.out.println(Player2.getInboxMsg());
        //System.out.println("FLAG 4");
        //System.out.println(Player1.getInboxMsg());

        Scanner kb = new Scanner(System.in);
        String msg = "";
        while (!msg.equalsIgnoreCase("q")){
            System.out.println("Enter: ");
            msg = kb.next();
            Player1.outboxAddMsg(msg);
            Player2.outboxAddMsg(msg);
        }

    }
}
