/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BSG;
import com.BSG.Comms.Comms;
import com.BSG.GameBackEndAttributes.Player;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author carolinemansueti CameronKane
 */
public class GameBackend {
    Comms playerComms;
    Scanner kb = new Scanner(System.in);
    boolean isPlayer1;
    Player thisPlayer;

    public GameBackend(boolean isP1) throws InterruptedException {
        thisPlayer = new Player(isP1);
        isPlayer1 = isP1;

        // Boot playerComms
        bootComms();

        //set ships (will be replaced with dynamic placing by user)
        setPlayerShips();
    }

    public void bootComms() throws InterruptedException {
        if (isPlayer1){
            playerComms = new Comms();
            System.out.println("The Host IP is: " + playerComms.getHost());
            while (playerComms.server.isWaitingForP2()){
                System.out.println("Waiting for player 2 connection");
                Thread.sleep(5000);
            }
        }
        else {
            System.out.println("What is the IP of Player One");
            String host = kb.next();
            playerComms = new Comms(host);
        }
        return;
    }

    public void setPlayerShips(){
        thisPlayer.setShips();
        System.out.println("Ships have been set by default");
        return;
    }

    public void getNextTarget(){
        System.out.println("Your turn!!");

        System.out.println("Target Row:"); // X
        int x = kb.nextInt();
        System.out.println("Target Column:"); // Y
        int y = kb.nextInt();
        thisPlayer.setNextTarget(x, y);
        return;
    }

    public void execute(){
        new GameBackendThread(this).start();
    }

//    public void oldMain(){
//            // TODO code application logic here
//
//            Scanner keyboard = new Scanner(System.in);
//
//            Board board = new Board();
//            board.place_ships_randomly();
//            System.out.print("BOARD 1: \n");
//            board.display();
//
//            Board other_board = new Board();
//            other_board.place_ships_randomly();
//            System.out.print("BOARD 2: \n");
//            other_board.display();
//
//
//            while(!board.fleet_sunk() && !other_board.fleet_sunk())
//            {
//                System.out.print("Player ONE enter row ");
//                int x = keyboard.nextInt();
//                System.out.print("and column: ");
//                int y = keyboard.nextInt();
//                other_board.checkHit(x, y);
//
//                System.out.print("Player TWO enter row ");
//                int a = keyboard.nextInt();
//                System.out.print("column: ");
//                int b = keyboard.nextInt();
//                board.checkHit(a, b);
//
//
//
//            }
//
//
//
//            if(board.fleet_sunk())
//            {
//                System.out.println("Player 2 won");
//            }
//            else
//            {
//                System.out.print("\n Player 1 won");
//            }
//
//
//
//        }
//    }
}
