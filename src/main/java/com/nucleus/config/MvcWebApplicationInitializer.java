package com.nucleus.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MvcWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public MvcWebApplicationInitializer() {
        super(WebSecurityConfig.class);
    }

}
