package net.halflite.example.api;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

import net.halflite.example.api.module.AppContextListener;

/**
 * Main App
 *
 * @author halflite
 */
public class App {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		ServletContextHandler contextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
		contextHandler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
		contextHandler.addEventListener(new AppContextListener());
		
		server.start();
		server.join();
	}
}
