/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgame;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author carolinemansueti
 */
public class Board {
    
    public char[][] board = new char[10][10];
    char hit = 'h';
    char miss = 'm';
    
   
    //each board will have a fleet of 5 ships
    public Carrier carrier = new Carrier();
    public Cruiser cruiser = new Cruiser();
    public Destroyer destroyer = new Destroyer();
    public Submarine submarine = new Submarine();
    public Battleship battleship = new Battleship();
    
    public Ship [] fleet = {carrier, cruiser, destroyer, submarine, battleship};
    
    public Board()
    {
        for(int row = 0; row < 10; row++)
        {
            for(int column = 0; column < 10; column++)
            {
                board[row][column] = 'e';
            }
        }
        
        
    }
    
    public void display()
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean cell_is_occupied(int x, int y)
    {
        return board[x][y] != 'e';
    }
    
    public boolean cell_is_empty(int x, int y)
    {
        return board[x][y] == 'e';
    }
    
    public char who_is_in_cell(int x, int y)
    {
        return board[x][y];
    }
    
    public void shot_fired_here(int x, int y)
    {
        
    }
    
    public void is_a_hit()
    {
        
    }
    
    public void is_a_miss()
    {
        
    }
            
    public void place_ships_player(Ship [] fleet){
        
    }
    
    public void place_ships_default(){
           
        for(int index = 0; index < this.fleet.length; index++){
           
            
            //randomly set ship's orientation to horizontal or vertical
            Random random = new Random();
            this.fleet[index].set_orientation(random.nextBoolean());
            int span = this.fleet[index].get_size();

            //initialize local variables
            boolean flag = false;
            int x;
            int y;
            
             
            //check if there are any other ships within the span of this x, y pair
            //first checking for when the random orientation is set to horizontal
            if(this.fleet[index].get_orientation() == true)  //if ship is horizontal
            {
                do
                {
                    x = Math.abs(random.nextInt() % (10 - span));
                    y = Math.abs(random.nextInt() % 10);
        
                    //check cell's occupied status
                    for(int i = x; i < x + span; i++)
                    {
                        if(cell_is_occupied(i, y))
                            flag = true;        
                    }
   
                }while(flag);
    
                //save the ship's location
                this.fleet[index].set_location(x, y);
                
                //and update the board
                for(int i = x; i < x + this.fleet[index].get_size(); i++)
                {
                    this.board[i][y] = this.fleet[index].get_identifer();
                }
                
            }
            else    //otherwise the ship is vertical
            {
                do
                {
                    x = Math.abs(random.nextInt() % 10);
                    y = Math.abs(random.nextInt() % (10 - span));
        
                    //check cell's occupied status
                    for(int i = y; i < y + span; i++)
                    {
                        if(cell_is_occupied(x, i))
                            flag = true;
                    }
        
                }while(flag);
    
                //save the ship's location
                this.fleet[index].set_location(x, y);
    
                //and update the board
                for(int i = y; i < y + span; i++)
                {
                    this.board[x][i] = this.fleet[index].get_identifer();
                }
     
     
            }
            
        } 
          

        
        
    }
    
     
    
}
