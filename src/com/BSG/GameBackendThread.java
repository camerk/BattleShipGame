package com.BSG;

import com.BSG.Comms.Comms;
import com.BSG.GameBackEndAttributes.Player;

public class GameBackendThread extends Thread {
    GameBackend backend;
    Comms playerComms;
    Player thisPlayer;
    boolean isPlayer1;

    public GameBackendThread(GameBackend gameBackend){
        backend = gameBackend;
        playerComms = backend.playerComms;
        thisPlayer = backend.thisPlayer;
        isPlayer1 = backend.isPlayer1;

    }
    @Override
    public void run(){
        if (isPlayer1){
            player1Routine();
        }
        else {
            player2Routine();
        }
    }

    public void player1Routine(){
        //get x y of first shot
        int targetX;
        int targetY;
        int incomingX;
        int incomingY;
        boolean enemyHitMe;

        thisPlayer.display();
        backend.getNextTarget();
        playerComms.fireFirstShot(thisPlayer.getTargetingX(), thisPlayer.getTargetingY());
        System.out.println("Waiting for opponent...");

        playerComms.readResponse();
        while(!playerComms.isGameOver()){
            incomingX = playerComms.getIncomingX();
            incomingY = playerComms.getIncomingY();
            //Check if hit
            enemyHitMe = thisPlayer.fieldHit(incomingX, incomingY);
            //get our return shot coordinates from player
            thisPlayer.display();
            backend.getNextTarget();
            playerComms.returnFire(enemyHitMe, thisPlayer.getTargetingX(), thisPlayer.getTargetingY());
            System.out.println("Waiting for opponent...");
            playerComms.readResponse(); // this should block until a message comes through
        }
    }

    public void player2Routine(){
        //get x y of first shot
        int targetX;
        int targetY;
        int incomingX;
        int incomingY;
        boolean enemyHitMe;

        thisPlayer.display();
        System.out.println("Waiting for opponent...");
        playerComms.fieldFirstShot();
        while(!playerComms.isGameOver()){
            incomingX = playerComms.getIncomingX();
            incomingY = playerComms.getIncomingY();
            ///Check if hit
            enemyHitMe = thisPlayer.fieldHit(incomingX, incomingY);
            //get our return shot coordinates from player
            thisPlayer.display();
            backend.getNextTarget();
            playerComms.returnFire(enemyHitMe, 3, 4);
            System.out.println("Waiting for opponent...");
            playerComms.readResponse(); // this should block until a message comes through
        }

        //CHECK END GAME CONDITIONS
    }

}
