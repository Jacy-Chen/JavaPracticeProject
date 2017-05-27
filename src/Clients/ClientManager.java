package Clients;

import java.util.ArrayList;
import Utils.MessageQueue;

public class ClientManager {
	// Properties
//	private MessageQueue messageQueue = null;
	private ArrayList<Client> cls = null;
	static final int CLIENT_SIZE = 100;
	
	public ClientManager() {
//		this.messageQueue = MessageQueue.getInstance();
		System.out.format("[%s]: Init! %n", this.getClass().getName());
		this.cls = new ArrayList<Client>();
		for (int i = 0; i < CLIENT_SIZE; i++) {
			this.cls.add(new Client(i+1));
		}
	}
	
	public void start() {
		System.out.format("[%s]: start! %n", this.getClass().getName());
		for (int i = 0; i < CLIENT_SIZE; i++) {
				new Thread(this.cls.get(i)).start();
		}
	}
}
