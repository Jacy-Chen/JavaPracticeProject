package Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class MessageQueue {
	private static MessageQueue messageQueueinstance = null;
	private static final Object lock = new Object();
	
	// Properties
	private Queue<String> queue;
	
	protected MessageQueue() {
		this.queue = new LinkedList<String>();
	}
	
	static public synchronized MessageQueue getInstance () {
		// Double confirm synchronization 
		MessageQueue q = messageQueueinstance;
		if (q == null) {
			synchronized (lock) {
				q = messageQueueinstance;
				if (q == null) {
					q = new MessageQueue();
					messageQueueinstance = q;
				}
			}
		}
		return messageQueueinstance;
	}
	
	public void addMessage(String msg) {
		// add require Mutux
		synchronized (this.queue) {
			this.queue.add(msg);
		}
	} 
	
	public String popMessage() {
		// pop require Mutux 
		synchronized (this.queue) {
			if (this.queue.size() == 0) {
				return null;
			}
			return this.queue.poll();
		}
	}
	
	public int getSize() {
		synchronized (this.queue) {
			return this.queue.size();
		}
	}
	
}
