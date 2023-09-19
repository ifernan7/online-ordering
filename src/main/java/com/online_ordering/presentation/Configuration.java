package com.online_ordering.presentation;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}