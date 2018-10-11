package com.BSG.Comms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    public ServerSocket serverSocket;
    public Socket p1Connection, p2Connection;
    public ObjectOutputStream streamToP1, streamToP2;
    public ObjectInputStream streamFromP1, streamFromP2;
    private Server thisServer;

    public ServerThread(Server server){
        serverSocket = server.serverSocket;
        p1Connection = server.p1Connection;
        p2Connection = server.p2Connection;
        streamToP1 = server.streamToP1;
        streamToP2 = server.streamToP2;
        streamFromP1 = server.streamFromP1;
        streamFromP2 = server.streamFromP2;
        thisServer = server;
    }


    public void run() {
        try {
            p1Connection = serverSocket.accept();
            streamToP1 = new ObjectOutputStream(p1Connection.getOutputStream());
            streamToP1.flush();
            streamFromP1 = new ObjectInputStream(p1Connection.getInputStream());
            p2Connection = serverSocket.accept();
            streamToP2 = new ObjectOutputStream(p2Connection.getOutputStream());
            streamToP2.flush();
            streamFromP2 = new ObjectInputStream(p2Connection.getInputStream());
            System.out.println("Player 2 connected");
            thisServer.setWaitingForP2(false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        boolean someoneQuit = false;
        while (!someoneQuit) { // if one of the players quits, the match will end.
            try {
                //P1 turn to talk
                String msgFromP1 = (String) streamFromP1.readObject(); // what p1Connection says
                if (!msgFromP1.equalsIgnoreCase("")) { // if what p1Connection says q for quit
                    streamToP2.writeObject(msgFromP1);
                    //System.out.println("Server Relayed P1 Message: " + msgFromP1);
                }
                if (msgFromP1.equalsIgnoreCase("q")){
                    someoneQuit = true;
                    continue;
                }
                //P2 Turn to talk
                String msgFromP2 = (String) streamFromP2.readObject(); // what p2Connection says
                if (!msgFromP2.equalsIgnoreCase("")) { // if what p1Connection says is something
                    streamToP1.writeObject(msgFromP2);
                    //System.out.println("Server Relayed P2 Message: "+ msgFromP2);
                }
                if (msgFromP1.equalsIgnoreCase("q")){
                    someoneQuit = true;
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SEVER STOPPED RUNNING");
    }

}
