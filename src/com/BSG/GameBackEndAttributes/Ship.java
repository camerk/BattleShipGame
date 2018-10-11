/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BSG.GameBackEndAttributes;

/**
 *
 * @author carolinemansueti cameronkane
 */
public class Ship {
    private int num_of_hits;
    private boolean sunk;
    private int size;
    private char identifier;
    private int x_coordinates[];
    private int y_coordinates[];
    private boolean horizontal;
    private boolean parts_hit[];
    
    public void initialize_hits()
    {
        this.num_of_hits = 0;
    }
    
    private void hit_count_add()
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
        this.parts_hit = new boolean[size];
    }
    
    public int get_size()
    {
        return size;
    }
    
    public void set_identifier(char c)
    {
        this.identifier = c;
    }
    
    public char get_identifier()
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
    
    public void set_location(int x, int y)
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

    public void set_location(int x, int y, boolean orientation)// overloaded to set orientation as well with location
    {
        x_coordinates= new int[this.get_size()];
        y_coordinates = new int[this.get_size()];
        set_orientation(orientation);


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
    
    public int[] get_location()
    {
        int[] position = {this.x_coordinates[0], this.y_coordinates[0]};
        return position;
    }
    
    public boolean was_shot(int x, int y)
    {
        //check if the x, y coordinates passed in match the x, y coordinates of the ship
        for (int i = 0; i < this.get_size(); i++) {
	    if(x_coordinates[i] == x && y_coordinates[i] == y) {
	        if (parts_hit[i] == false) {
                this.hit_count_add();
                parts_hit[i] = true;
                return true;
                }
	        }
	    }

        return false;
    }
        
    
}
