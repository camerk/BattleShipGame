package com.BSG;

import com.BSG.Comms.Comms;

import java.util.Random;

//QUIT DOESN'T WORK in comes yet, threads puke errors when the player sends quit message
public class CommsTest {

    public static void main(String[] args) throws InterruptedException {
        // creating player one
        Comms player1Comms = new Comms();
        System.out.println("Player 1's ID is" + player1Comms.getPlayerID());
        System.out.println("Player 1's host is " + player1Comms.getHost());
        // creating player 2
        Comms player2Comms = new Comms("localhost");
        System.out.println("Player 2's ID is" + player2Comms.getPlayerID());
        System.out.println("Player 2's host is " + player2Comms.getHost());
        //Player 1 goes first
        player1Comms.fireFirstShot(0,0);
        //player1Comms.readResponse();// Player 1 is going to sleep and blocks whatever thread this is called on
        player2Comms.fieldFirstShot();

        System.out.println("Player 2 registered opponent hit on " + player2Comms.getIncomingX()+
                ","+ player2Comms.getIncomingY());
        System.out.println("P2 is going to fire on 1,1 and tell P1 he Hit a ship");
        player2Comms.returnFire(true,1,1);
        player1Comms.readResponse();
        System.out.println("Player 1 read that hit was " + player1Comms.getLastShotHit());
        System.out.println("Player 1 registered opponent miss on " + player1Comms.getIncomingX()+
                ","+ player1Comms.getIncomingY());
        System.out.println("P1 is going to fire on 5,5 and tell P2 he missed");
        player1Comms.returnFire(false,5,5);
        player2Comms.readResponse();
        System.out.println("Player 2 read that hit was " + player2Comms.getLastShotHit());
        //player2Comms.quitGame();


        /*
        Code should look like:
        if player1
            PlayerOneRoutine()
        else
            PlayerTwoRoutine()
        */
    }

    public void player1Routine(Comms player1){
        //get x y of first shot
        int x = 1;
        int y = 1;
        player1.fireFirstShot(x, y);
        player1.readResponse();
        boolean enemyHitMe;
        Random random = new Random();
        while(!player1.isGameOver()){
            int incomingX = player1.getIncomingX();
            int incomingY = player1.getIncomingY();
            //Check if hit
            //get our return shot coordinates from player
            enemyHitMe = true;
            x = random.nextInt(9 - 0 + 1);
            y = random.nextInt(9 - 0 + 1);
            player1.returnFire(enemyHitMe, 3, 4);
            player1.readResponse(); // this should block until a message comes through
        }
    }

    public void player2Routine(Comms player2){
        int x,y;
        player2.fieldFirstShot();
        boolean enemyHitMe;
        Random random = new Random();
        while(!player2.isGameOver()){
            int incomingX = player2.getIncomingX();
            int incomingY = player2.getIncomingY();
            //Check if hit
            //get our return shot coordinates from player
            enemyHitMe = true;
            x = random.nextInt(9 - 0 + 1);
            y = random.nextInt(9 - 0 + 1);
            player2.returnFire(enemyHitMe, 3, 4);
            player2.readResponse(); // this should block until a message comes through
        }
    }

}
