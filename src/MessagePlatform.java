import java.util.Date;
import java.util.logging.Logger;

import Clients.ClientManager;
import Services.ServerManager;

public class MessagePlatform {
	// Properties 
	private static MessagePlatform messagePlatformInstance = null;//Singleton Instance for the Massage platform 
	private ClientManager clientManager;
	private ServerManager serverManager;	
	// Methods
	protected MessagePlatform() {
		// TODO Auto-generated constructor stub
		this.clientManager = new ClientManager();
		this.serverManager = new ServerManager();
	}
	
	// Singleton Function - Get the message platform
	public static MessagePlatform getInstance() {
		if (messagePlatformInstance == null) {
			messagePlatformInstance = new MessagePlatform();
			System.out.println("[MessagePlatform]: message platform singleton instance created!");
		}
		return messagePlatformInstance;
	}
	
	public void startCommunication() {
//		this.clientManager
		this.clientManager.start();
		this.serverManager.start();
	
	}
	
	// Project Entry
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessagePlatform messagePlatform = MessagePlatform.getInstance();
		messagePlatform.startCommunication();
	}

}
