/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgame;

/**
 *
 * @author carolinemansueti
 */
public class Board {
    
    public int[][] board = new int[10][10];
    int hit = 0;
    int miss = 1;
    
    //assemble fleet
    Carrier carrier = new Carrier();
    Cruiser cruiser = new Cruiser();
    Destroyer destroyer = new Destroyer();
    Submarine submarine = new Submarine();
    Battleship battleship = new Battleship();
    
    //put shipsinto an array to easily pass ships to placement methods
    Ship[] fleet = new Ship[5];
    //fleet[0] = carrier;
    
    
  
    
    public void cell_is_occupied(Ship ship)
    {
        
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
            
    public void place_ships_player(){
        
    }
    
    public void place_ships_default(){
        
    }
    
}
