package com.kushmiruk.chapter04.javaconfig;

import com.kushmiruk.chapter02.annotation.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ImportResource(value = "classpath:chapter04/META-INF/spring/javaconfig/app-context-xml.xml")
@PropertySource(value = "classpath:chapter04/META-INF/spring/javaconfig/message.properties")
@ComponentScan(basePackages = "com.kushmiruk.chapter04.javaconfig")

public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(environment.getProperty("message"));
    }

    @Bean(name = "renderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
