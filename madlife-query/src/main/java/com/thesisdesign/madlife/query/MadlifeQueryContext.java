package com.thesisdesign.madlife.query;

import com.thesisdesign.madlife.common.MadlifeCommonContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = {
        "com.thesisdesign.madlife.query",
})
@Import(value = {
        MadlifeCommonContext.class
})
public class MadlifeQueryContext {
}
