package Clients;

import java.util.Date;

import Utils.MessageQueue;

public class Client implements Runnable{
	private int id;
	private int messageCount;
	private MessageQueue queue;
	
	public Client(int pId) {
		this.id = pId;
		this.messageCount = 0;
		queue = MessageQueue.getInstance();
	}
	
	public Client() {
		this.id = -1; //inValid Id number 
	}
	
	private String generateMessage() {
		this.messageCount++;
		return String.format("[Client %d] Send message #%d at time: %s!", this.id, this.messageCount, new Date());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 3 min == 180000 miliseconds == 18000 times
		for (int i = 0; i < 180; i++) {
			try {
				String msg = generateMessage();
//				System.out.println(msg);
				this.queue.addMessage(msg);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
