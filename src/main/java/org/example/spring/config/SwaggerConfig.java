package org.example.spring.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version}")
    private String version;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot API")
                        .version(version)
                        .description("Spring Boot API pour gérer une boutique en ligne"));
    }

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Auchan")
                .packagesToScan("org.example.spring.web.controllers", "org.example.spring.web.dto")
                .packagesToExclude("org.example.spring.data")
                .build();
    }
}
