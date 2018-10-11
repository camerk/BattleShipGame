package com.BSG;

import com.BSG.Comms.Comms; // imports networking
import com.BSG.GameBackEndAttributes.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        boolean isP1;
        Scanner kb = new Scanner(System.in);
        GameBackend gameBackend;

        System.out.println("Are you player one? (Player one boots server) (true/false)");
        isP1 = kb.nextBoolean();

        gameBackend = new GameBackend(isP1);
        gameBackend.execute();
    }
}
