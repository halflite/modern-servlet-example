package net.halflite.example.api.module;

import javax.inject.Singleton;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
	    Config config = ConfigFactory.load();
	    bind(Config.class).toInstance(config);
	    
		bind(Gson.class).in(Singleton.class);
		
		install(new PersistModule());
	}

}
