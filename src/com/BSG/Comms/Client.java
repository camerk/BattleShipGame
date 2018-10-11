package com.BSG.Comms;

import sun.misc.Queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This is the chat client program.
 * Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class Client {
	static int playerCount = 1;
	public int playerID;
	private String hostname;
	private int port;
	private Queue<String> inbox;
	private Queue<String> outbox;
	private ObjectInputStream inboxO;
	private ObjectOutputStream outboxO;
	public boolean kill = false;

	public Client(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
		this.playerID = playerCount;
		playerCount++;
		inbox = new Queue<String>();
		outbox = new Queue<String>();
	}

	public void execute() {
		try {
			Socket socket = new Socket(hostname, port);



			new WriteThread(socket, this).start();
			new ReadThread(socket, this).start();

		} catch (UnknownHostException ex) {
			System.out.println("Player " + playerID + " Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Player " + playerID + " I/O Error: " + ex.getMessage());
		}

	}


	public void outboxAddMsg(String msg){
		outbox.enqueue(msg);
		return;
	}


	public String getOutboxMsg() throws InterruptedException {
		return outbox.dequeue();
	}


	public void inboxAddMsg(String msg){
		inbox.enqueue(msg);
		return;
	}


	public String getInboxMsg(){
		while (inbox.isEmpty()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String x = null;
		try {
			x = inbox.dequeue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return x;
	}


	public boolean isOutboxEmpty(){
		return outbox.isEmpty();
	}


	public ObjectOutputStream getOutboxO(){
		return outboxO;
	}


	public ObjectInputStream getInboxO(){
		return inboxO;
	}
}