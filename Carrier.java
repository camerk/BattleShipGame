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
public class Carrier extends Ship{
    public Carrier()
    {
        this.initialize_hits();
        this.initialize_sunk();
        this.set_size(5);
        this.set_identifier('c');
        this.set_orientation(true);
    }
}
