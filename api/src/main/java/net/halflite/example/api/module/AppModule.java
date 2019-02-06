package net.halflite.example.api.module;

import javax.inject.Singleton;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Gson.class).in(Singleton.class);
	}

}
