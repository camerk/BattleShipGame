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
public class BattleshipGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Board player1 = new Board();
        
        
               
        player1.display();
        
       player1.place_ships_default();
       player1.display();
        
         
         Board board = new Board();
         
    }
    
}
