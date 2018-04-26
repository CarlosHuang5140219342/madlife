package com.thesisdesign.madlife.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:META-INF/spring/applicationContext.xml")
public class DubboContext {
}
