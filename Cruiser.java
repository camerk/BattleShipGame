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
public class Cruiser extends Ship {
    public Cruiser()
    {
        this.initialize_hits();
        this.initialize_sunk();
        this.set_size(3);
        this.set_identifier('r');
        this.set_orientation(true);
    }
    
}
