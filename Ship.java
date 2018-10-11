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
public class Ship {
    private int num_of_hits;
    private boolean sunk;
    private int size;
    private char identifier;
    private int x_coordinates[];
    private int y_coordinates[];
    private boolean horizontal;
    
    public void initialize_hits()
    {
        this.num_of_hits = 0;
    }
    
    public void update_hit_count()
    {
        this.num_of_hits++;
    }
    
    public int get_hit_count()
    {
        return num_of_hits;
    }
    
    public void initialize_sunk()
    {    
        this.sunk = false;
    }
    
    public boolean is_sunk()
    {
        return this.get_hit_count() == this.get_size();
    }
    
    public void set_size(int size)
    {
        this.size = size;
    }
    
    public int get_size()
    {
        return size;
    }
    
    public void set_identifier(char c)
    {
        this.identifier = c;
    }
    
    public char get_identifer()
    {
        return identifier;
    }
    
    public void set_orientation(boolean orientation)
    {
        this.horizontal = orientation;
    }
    
    public boolean get_orientation()
    {
        return horizontal;
    }
    
    public void location(int x, int y)
    {
        x_coordinates= new int[this.get_size()];
        y_coordinates = new int[this.get_size()];

          

        for (int i = 0; i < this.get_size(); i++)
	 {
             x_coordinates[i] = x;
             y_coordinates[i] = y;
             
             //check if the ship is horizontal
             //if it is horzontal, update the x coordinates 
             //if it is not horizontal, update the y coordinates
            if(this.get_orientation())
                x++;
            else
                y++;
	 }

      }
    
    public boolean was_shot(int x, int y)
    {
        //check if the x, y coordinates passed in match the x, y coordinates of the ship
        for (int i = 0; i < this.get_size(); i++)
	{
	    if(x_coordinates[i] == x && y_coordinates[i] == y)
	    {
	        this.update_hit_count();
	        return true;
	    }
	 }

        return false;
    }
        
    
}
