package net.halflite.example.api.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import net.halflite.example.api.servlet.IndexServlet;

public class AppContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new AppServletModule());
	}

	private static class AppServletModule extends ServletModule {
		@Override
		protected void configureServlets() {
			install(new AppModule());
			
			serve("/").with(IndexServlet.class);
		}
	}
}
