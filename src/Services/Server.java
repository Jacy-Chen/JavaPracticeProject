package Services;

import java.util.Date;

import javax.lang.model.element.VariableElement;

import Utils.MessageQueue;

public class Server implements Runnable {

	private MessageQueue queue;
	private int idleCounter;
	
	public Server() {
		this.queue = MessageQueue.getInstance();
		this.idleCounter = 0;
	}
	
	@Override
	public void run() {
		while(true) {
			String message = this.queue.popMessage();
			if (message != null) {
				System.out.format("[%s]:At %s, Receive data: %s %n", this.getClass().getName(), new Date(), message);
				this.idleCounter = 0;
			} else {
				try {
					this.idleCounter++;
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (this.idleCounter > 100) {
				// if server under idle condition for 1 second, exit the listening process.
				System.out.format("[%s]:At %s, Server exit! %n", this.getClass().getName(), new Date());
				break;
				
			}
		}
	}
	
}
