package net.halflite.example.api.module;

import javax.inject.Singleton;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import net.halflite.example.api.dao.AccountDao;
import net.halflite.example.api.dao.AccountDaoImpl;
import net.halflite.example.api.dao.AdminDao;
import net.halflite.example.api.dao.AdminDaoImpl;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        Config config = ConfigFactory.load();
        bind(Config.class).toInstance(config);

        Gson gson = new GsonBuilder().serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        bind(Gson.class).toInstance(gson);

        install(new PersistModule());

        bind(AccountDao.class).to(AccountDaoImpl.class)
                .in(Singleton.class);
        bind(AdminDao.class).to(AdminDaoImpl.class)
                .in(Singleton.class);
    }

}
