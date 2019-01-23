package net.halflite.example.api.module;

import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import freemarker.ext.servlet.FreemarkerServlet;
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

            bind(FreemarkerServlet.class).in(Singleton.class);

            serve("/").with(IndexServlet.class);
            Map<String, String> initParam = ImmutableMap.<String, String> builder()
                    .put("TemplatePath", "classpath:views")
                    .put("NoCache", "true")
                    .put("ResponseCharacterEncoding", "fromTemplate")
                    .put("ExceptionOnMissingTemplate", "true")
                    .put("incompatible_improvements", "2.3.28")
                    .put("template_exception_handler", "rethrow")
                    .put("template_update_delay", "0")
                    .put("default_encoding", "UTF-8")
                    .put("output_encoding", "UTF-8")
                    .put("locale", "ja_JP")
                    .put("number_format", "0.##########")
                    .build();
            serve("*.ftl").with(FreemarkerServlet.class, initParam);
        }
    }
}
