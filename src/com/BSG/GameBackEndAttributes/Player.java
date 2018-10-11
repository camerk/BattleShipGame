/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BSG.GameBackEndAttributes;

/**
 *
 * @author carolinemansueti CameornKane
 */
public class Player {
    private Board my_Ship_board = new Board(true);
    private Board my_Firing_board = new Board(false);
    private boolean isPlayerOne;
    private int playerID;
    private int targetingX;
    private int targetingY;
    
    public Player(boolean isPlayerOne)
    {
        this.isPlayerOne = isPlayerOne;
        if(isPlayerOne){
            playerID = 1;
        }
        else {
            playerID = 2;
        }

    }

    public void setShips(){  //CHANGE THIS
        my_Ship_board.place_ships_randomly();
    }

    public boolean fieldHit(int x, int y){
        return my_Ship_board.checkHit(x,y);
    }

    public void logShot(boolean wasAHit, int x, int y){
        my_Firing_board.log_shot(wasAHit, x, y);
        return;
    }

    public void setNextTarget(int x, int y){
        targetingX = x;
        targetingY = y;
        return;
    }

    public int getTargetingX(){
        return targetingX;
    }

    public int getTargetingY(){
        return targetingY;
    }

    public int getPlayerID(){
        return playerID;
    }

    public void display(){
        System.out.println("Firing Board:");
        my_Firing_board.display();
        System.out.println("My Ships Board:");
        my_Ship_board.display();
        return;
    }

}
