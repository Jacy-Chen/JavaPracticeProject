package Services;

import Utils.MessageQueue;

public class ServerManager {
		// Properties 
		Server server = null;
	
		// Methods
		public ServerManager() {
			this.server = new Server();
		}
		
		public void start() {
			System.out.format("[%s]: start! %n", this.getClass().getName());
			new Thread(this.server).start();
		}
		
		
}
