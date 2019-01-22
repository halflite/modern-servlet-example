package net.halflite.example.api;

import org.eclipse.jetty.server.Server;

/**
 * Main App
 *
 * @author halflite
 */
public class App {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		server.start();
		server.join();
	}
}
