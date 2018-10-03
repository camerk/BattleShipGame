package com.BSG;

public class Board {
    int [][] fireMap = new int[10][10]; // Where play shoots at opponent
    int [][] shipMap = new int[10][10]; // Where player has ships, and keeps track of enemy fire


    public void printFireMap() {
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                System.out.printf("%5d ", fireMap[i][j]);
            }
            System.out.println();
        }
    }

    public void printShipMap() {
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                System.out.printf("%5d ", shipMap[i][j]);
            }
            System.out.println();
        }
    }

}
