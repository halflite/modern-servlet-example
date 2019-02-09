package net.halflite.example.api.config;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;

@Singleton
public class PersistConfig implements Config {

    private final Dialect dialect;

    private final DataSource dataSource;

    @Override
    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public Dialect getDialect() {
        return this.dialect;
    }

    @Inject
    public PersistConfig(Dialect dialect, DataSource dataSource) {
        this.dialect = dialect;
        this.dataSource = dataSource;
    }
}
