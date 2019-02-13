package net.halflite.example.api.module;

import static com.google.inject.name.Names.named;

import javax.inject.Singleton;
import javax.sql.DataSource;

import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.zaxxer.hikari.HikariDataSource;

import net.halflite.example.api.config.PersistConfig;

public class PersistModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Dialect.class).to(MysqlDialect.class)
                .in(Singleton.class);
        bind(org.seasar.doma.jdbc.Config.class).annotatedWith(named("config"))
                .to(PersistConfig.class);
    }

    @Provides
    @Singleton
    public DataSource provideDataSource(com.typesafe.config.Config config) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(config.getString("db.url"));
        ds.setUsername(config.getString("db.user"));
        ds.setPassword(config.getString("db.password"));
        return ds;
    }
}
