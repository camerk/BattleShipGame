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
public class Battleship extends Ship{
    public Battleship()
    {
        this.initialize_hits();
        this.initialize_sunk();
        this.set_size(4);
        this.set_identifier('b');
        this.set_orientation(true);
    }
}
