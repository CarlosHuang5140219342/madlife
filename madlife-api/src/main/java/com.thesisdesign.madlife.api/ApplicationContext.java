package com.thesisdesign.madlife.api;

import com.thesisdesign.madlife.query.MadlifeQueryContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(value = "com.thesisdesign.madlife.api")
@Import(value = {
        MadlifeQueryContext.class
})
public class ApplicationContext implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(10010);
    }
}