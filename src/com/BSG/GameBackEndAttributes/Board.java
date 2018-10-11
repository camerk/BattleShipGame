/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BSG.GameBackEndAttributes;

import java.util.Random;

/**
 * @author carolinemansueti
 */
public class Board {

    public String[][] board = new String[10][10];
    boolean isShipsBoard;
    char hit = 'h';
    char miss = 'm';


    //each board will have a fleet of 5 ships
    public Carrier carrier;
    public Cruiser cruiser;
    public Destroyer destroyer;
    public Submarine submarine;
    public Battleship battleship;

    public Ship[] fleet = new Ship[5];

    public Board(boolean isShipBoard) {
        if (isShipBoard) {
            //each board will have a fleet of 5 ships
            carrier = new Carrier();
            fleet[0] = carrier;
            cruiser = new Cruiser();
            fleet[1] = cruiser;
            submarine = new Submarine();
            fleet[2] = submarine;
            destroyer = new Destroyer();
            fleet[3] = destroyer;
            battleship = new Battleship();
            fleet[4] = battleship;
            this.isShipsBoard = true;
        }
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                board[row][column] = "e";
            }
        }
    }

    public void display() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean cell_is_occupied(int x, int y) {
        return board[x][y].charAt(0) != 'e';
    }

    public boolean cell_is_empty(int x, int y) {
        return board[x][y].charAt(0) == 'e';
    }

    public char who_is_in_cell(int x, int y) {
        return board[x][y].charAt(0);
    }

    // This is fore firing grid ONLY
    public void log_shot(boolean wasAHit, int x, int y) {
        if (wasAHit){
            board[x][y] = "" + 'h';
        }
        else {
            board[x][y] = "" + 'm';
        }
    }

    public boolean checkHit(int x, int y) {
        if (cell_is_occupied(x, y)) {
            char shipID = who_is_in_cell(x, y);

            //find ship whose identifier matches the one hit
            for (int i = 0; i < fleet.length; i++) {
                if (shipID == fleet[i].get_identifier()) {
                    fleet[i].was_shot(x, y);
                    board[x][y] = board[x][y] + 'h';
                    return true;
                }
            }
        }
         board[x][y] = board[x][y] + 'm';
         return false;
    }

    public boolean fleet_sunk() {
        return fleet[0].is_sunk() && fleet[1].is_sunk() && fleet[2].is_sunk() && fleet[3].is_sunk() && fleet[4].is_sunk();
    }

    public void place_ships_player(Ship[] fleet) {

    }

    public void place_ships_randomly() {

        System.out.println("Randomly placing ships...");
        for (int index = 0; index < fleet.length; index++) {
            //System.out.println("Placing ship: " + index);

            //randomly set ship's orientation to horizontal or vertical
            Random random = new Random();
            fleet[index].set_orientation(random.nextBoolean());
            int span = fleet[index].get_size();

            //initialize local variables
            boolean occupied;
            int x;
            int y;


            //check if there are any other ships within the span of this x, y pair
            //first checking for when the random orientation is set to horizontal
            if (fleet[index].get_orientation() == true)  //if ship is horizontal
            {
                do {
                    occupied = false;
                    x = Math.abs(random.nextInt() % (10 - span));
                    y = Math.abs(random.nextInt() % 10);
                    //System.out.println("h try");
                    //check cell's occupied status
                    for (int i = x; i < x + span; i++) {
                        if (cell_is_occupied(i, y))
                            occupied = true;
                    }

                } while (occupied);

                //save the ship's location
                fleet[index].set_location(x, y);

                //and update the board
                for (int i = x; i < x + fleet[index].get_size(); i++) {
                    this.board[i][y] = "" + fleet[index].get_identifier();
                }

            } else    //otherwise the ship is vertical
            {
                do {
                    occupied = false;
                    x = Math.abs(random.nextInt() % 10);
                    y = Math.abs(random.nextInt() % (10 - span));
                    //System.out.println("v try");
                    //check cell's occupied status
                    for (int i = y; i < y + span; i++) {
                        if (cell_is_occupied(x, i))
                            occupied = true;
                    }

                } while (occupied);

                //save the ship's location
                fleet[index].set_location(x, y);

                //and update the board
                for (int i = y; i < y + span; i++) {
                    this.board[x][i] = "" + fleet[index].get_identifier();
                }


            }


        }


    }


}
