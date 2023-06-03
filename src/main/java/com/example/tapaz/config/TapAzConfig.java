package com.example.tapaz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class TapAzConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("TapAz.avtomobil")
                .version("0.1")
                .description("Avtomobil Elanlari")
                .contact(new Contact().url("/api/").email("elnurmirzyev96@gmail.com").name("Elnur Mirzeyev")));
    }
}
