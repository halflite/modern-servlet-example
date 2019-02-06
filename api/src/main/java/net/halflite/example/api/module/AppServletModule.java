package net.halflite.example.api.module;

import java.util.Map;

import javax.inject.Singleton;

import org.webjars.servlet.WebjarsServlet;

import com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;

import freemarker.ext.servlet.FreemarkerServlet;
import net.halflite.example.api.servlet.IndexServlet;

public class AppServletModule extends ServletModule {
    
    @Override
    protected void configureServlets() {
        install(new AppModule());

        bind(WebjarsServlet.class).in(Singleton.class);
        bind(FreemarkerServlet.class).in(Singleton.class);

        serve("/").with(IndexServlet.class);
        serve("/webjars/*").with(WebjarsServlet.class);
        Map<String, String> fmInitParam = ImmutableMap.<String, String> builder()
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
        serve("*.ftl").with(FreemarkerServlet.class, fmInitParam);
    }
}
