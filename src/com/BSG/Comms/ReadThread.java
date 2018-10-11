package com.BSG.Comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
	private BufferedReader readFromServer;
	private ObjectInputStream inbox;
	private Socket socket;
	private Client client;

	public ReadThread(Socket socket, Client client) {
		this.socket = socket;
		this.client = client;

		try {
			InputStream input = socket.getInputStream();
			//readFromServer = new BufferedReader(new InputStreamReader(input));
			inbox = new ObjectInputStream(input);
		} catch (IOException ex) {
			System.out.println("Player " + client.playerID + " Error getting input stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				//String response = readFromServer.readLine();
				String response = (String) inbox.readObject();
				if (!response.equalsIgnoreCase("")) {
					client.inboxAddMsg(response);
					System.out.println("Read Message: " + response);
				}
				if (response.equalsIgnoreCase("q")){
					break;
				}
			} catch (IOException ex) {
				System.out.println("Player " + client.playerID + " Error reading from server: " + ex.getMessage());
				ex.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Player " + client.playerID + " Read thread quit");
	}
}