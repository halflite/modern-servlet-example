package net.halflite.example.api.module;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.webjars.servlet.WebjarsServlet;

import com.google.inject.Injector;

public class AppContextListenerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetInjector() {
        AppContextListener listener = new AppContextListener();
        Injector injector = listener.getInjector();
        
        // DIしたインスタンスが取得できるか
        WebjarsServlet webjarsServlet = injector.getInstance(WebjarsServlet.class);
        assertThat(webjarsServlet).isNotNull();
    }

}
