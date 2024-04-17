package com.turkcell.pair1.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface HttpSecurityCustomizer {
    void customize(HttpSecurity httpSecurity) throws Exception;
}
