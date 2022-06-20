package com.openhospital.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurer freemarkerClassLoaderConfig() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("localized_lookup", "false");
        properties.setProperty("template_update_delay", "15");

        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates");
        freeMarkerConfigurer.setFreemarkerSettings(properties);

        return freeMarkerConfigurer;
    }

}
