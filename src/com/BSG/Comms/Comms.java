package com.BSG.Comms;

public class Comms {
    static final int PORT = 3333;
    public Server server = null;
    Client client;
    String host = "localhost";
    int playerID;
    boolean isServer;
    int incomingX;
    int incomingY;
    boolean gameIsOver = false;
    boolean lastShotHit;
    boolean iWon = false;

    public Comms(){
        isServer = true;
        playerID = 1;
        server = new Server(PORT);
        server.execute();
        host =  server.serverSocket.getInetAddress().toString().split(" */ *")[0];
        client = new Client(host, PORT);
        client.execute();
    }
    public Comms(String host){
        isServer = false;
        playerID = 2;
        this.host = host;
        client = new Client(host,PORT);
        client.execute();
    }

    public boolean getLastShotHit(){
        return lastShotHit;
    }

    public void quitGame(){
        client.outboxAddMsg("q");
        client.kill = true;
    }

    public void fireFirstShot(int x, int y){
        String result = "FirstShot=" + x + "," + y;
        client.outboxAddMsg(result);
    }

    public void fieldFirstShot(){
        String response = client.getInboxMsg();

        if (response.startsWith("FirstShot=")){
            response = response.substring(10);
            String[] parts = response.split(" *, *");
            incomingX = Integer.parseInt(parts[0]);
            incomingY = Integer.parseInt(parts[1]);
        }
    }

    public int getIncomingX(){
        return incomingX;
    }
    public int getIncomingY(){
        return incomingY;
    }
    public int getPlayerID(){
        return playerID;
    }
    public String getHost(){
        return host;
    }
    public void gameOver(){
        gameIsOver = true;
    }
    public boolean isGameOver(){
        return gameIsOver;
    }

    public void readResponse(){
        String response = client.getInboxMsg();
        if(response.startsWith("hit;")) { // string should look like "Fire=3,2" x,y format
            lastShotHit = true;
            response = response.substring(4);
            if (response.startsWith("myturn=")) {
                response = response.substring(7);
                String[] parts = response.split(" *, *");
                incomingX = Integer.parseInt(parts[0]);
                incomingY = Integer.parseInt(parts[1]);
            }
            else if (response.startsWith("gameover")){
                iWon = true;
                gameOver();
            }
            else
            {
                System.out.println("I could not read: " + response);
            }
        }
        else if (response.equalsIgnoreCase("miss;")){
            lastShotHit = false;
            response = response.substring(5);
            if (response.equalsIgnoreCase("myturn=")) {
                response = response.substring(7);
                String[] parts = response.split(" *, *");
                incomingX = Integer.parseInt(parts[0]);
                incomingY = Integer.parseInt(parts[1]);
            }
            else{
                System.out.println("I could not read :" + response);
            }
        }
        else if (response.equalsIgnoreCase("quit")){
            gameOver();
        }
    }

    public void returnFire(boolean enemyHitMyFleet, int x, int y){
        String msg = "";
        if (enemyHitMyFleet) {
            msg = msg + "hit;";
        }
        else{
            msg = msg + "miss;";
        }
        msg = msg + "myturn=" + x + "," + y;
        client.outboxAddMsg(msg);
    }

}

