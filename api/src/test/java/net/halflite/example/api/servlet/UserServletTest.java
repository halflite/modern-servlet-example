package net.halflite.example.api.servlet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.AbstractModule;

import net.halflite.example.api.module.AppModule;
import net.halflite.example.api.module.AppModuleTest.AppModuleTestEnv;

public class UserServletTest {

    @Rule
    public final GuiceBerryRule rule = new GuiceBerryRule(UserServletTesttEnv.class);
    @Inject
    private UserServlet userServlet;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() {
    }

    @Test
    public void testGetId() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getServletPath()).thenReturn("/user/12");
        
        Long id = userServlet.getId(req);
        assertThat(id, is(12L));
    }

    public static class UserServletTesttEnv extends AbstractModule {
        @Override
        protected void configure() {
            install(new GuiceBerryModule());
            install(new AppModule());
        }
    }
}
