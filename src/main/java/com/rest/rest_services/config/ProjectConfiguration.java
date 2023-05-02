package com.rest.rest_services.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
public class ProjectConfiguration {

    private final Environment env;

    public ProjectConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthenticationInterceptor(){
        return new BasicAuthRequestInterceptor("admin@gmail.com", "admin");
    }
}
