/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vessel;

/**
 *
 * @author carolinemansueti
 */
public class Vessel {

    private boolean has_sunk;
    private int num_of_hits;
    private int length;
    private boolean horizontal;
    
    public void Vessel()
    {
        
    }
    
    public void Vessel(int length)
    {
        this.length = length;
        this.num_of_hits = 0;
        this.has_sunk = false;
        this.horizontal = true;
    }
    
    public void set_size(int length)
    {
        this.length = length;
    }
    
    public int get_size()
    {
        return this.length;
    }
    
    public void hit_status(int hit)
    {
      num_of_hits++; 
    }
    
    public int get_hit_status()
    {
        return this.num_of_hits;
    }
    
    public boolean sunk()
    {
        return this.get_size() == this.get_hit_status();
    }
    
    public void display()
    {
        
    }
    
}
