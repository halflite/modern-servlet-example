package net.halflite.example.api.config;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.MysqlDialect;

import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.AbstractModule;

import net.halflite.example.api.module.AppModule;

public class PersistConfigTest {

    @Rule
    public final GuiceBerryRule rule = new GuiceBerryRule(PersistConfigTestEnv.class);
    @Inject
    @Named("config")
    private Config config;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testConfig() {
        assertThat(config).isNotNull();
        
        assertThat(config.getDialect()).isInstanceOf(MysqlDialect.class);
        assertThat(config.getDataSource()).isNotNull();
    }

    public static class PersistConfigTestEnv extends AbstractModule {
        @Override
        protected void configure() {
            install(new GuiceBerryModule());
            install(new AppModule());
        }
    }
}
