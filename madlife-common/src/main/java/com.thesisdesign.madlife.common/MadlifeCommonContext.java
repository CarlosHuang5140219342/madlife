package com.thesisdesign.madlife.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = {
        "com.thesisdesign.madlife.common",
})
public class MadlifeCommonContext {
}
