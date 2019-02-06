package net.halflite.example.api.module;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.AbstractModule;

public class AppModuleTest {

    @Rule
    public final GuiceBerryRule rule = new GuiceBerryRule(AppModuleTestEnv.class);
    @Inject
    private Gson gson;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testConfigure() {
        assertThat(gson, is(notNullValue()));
    }

    public static class AppModuleTestEnv extends AbstractModule {
        @Override
        protected void configure() {
            install(new GuiceBerryModule());
            install(new AppModule());
        }
    }
}
