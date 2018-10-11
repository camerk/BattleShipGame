package com.BSG.Comms;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
	private ObjectOutputStream sendToServer;
	private Socket socket;
	private Client client;

	public WriteThread(Socket socket, Client client) {
		this.socket = socket;
		this.client = client;

		try {
			OutputStream output = socket.getOutputStream();
			sendToServer = new ObjectOutputStream(output);
			//sendToServer = new ObjectOutputStream(output, true);
		} catch (IOException ex) {
			System.out.println("Player " + client.playerID + " Error getting output stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void run() {
		String text = "";

		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!client.isOutboxEmpty()){
				try {
					text = client.getOutboxMsg();
					//System.out.println("Player " + client.playerID + "fired shot");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					sendToServer.writeObject(text);
					sendToServer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Sent message: " + text);
			}

		} while (!text.equals("q") && !client.kill);

		try {
			socket.close();
		} catch (IOException ex) {

			System.out.println("Player " + client.playerID + " Error writing to server: " + ex.getMessage());
		}
	}
}