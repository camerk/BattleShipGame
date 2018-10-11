package com.BSG.Comms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public ServerSocket serverSocket;
    public Socket p1Connection, p2Connection;
    public ObjectOutputStream streamToP1, streamToP2;
    public ObjectInputStream streamFromP1, streamFromP2;
    boolean waitingForP2 = true;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port, 1714);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        new ServerThread(this).start();
    }

    public void setWaitingForP2(boolean x){
        waitingForP2 = x;
        return;
    }

    public boolean isWaitingForP2(){
        return waitingForP2;
    }
}