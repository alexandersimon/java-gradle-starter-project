package com.example.config;

import io.swagger.v3.core.filter.SpecFilter;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Setter;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "example.api")
@ConditionalOnProperty(name="example.api.swagger.enable", havingValue = "true", matchIfMissing = false)
@Setter
public class OpenApiConfig {

    private String title;
    private String version;
    private String description;
    private String server_url;
    private String license;
    private String license_url;

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();

        return openApi.info(new Info().title(title)
                .version(version)
                .description(description)
                .termsOfService(server_url)
                .license(new License().name(license)
                        .url(license_url)));
    }
    @Bean
    public GroupedOpenApi internalOpenApi() {
        String packagesToscan[] = { "com.example.controller" };
        return GroupedOpenApi.builder().group("internal")
                .packagesToScan(packagesToscan).build();
    }
    @Bean
    public GroupedOpenApi externalOpenApi() {
        String packagesToscan[] = { "com.example.controller.external" };
        return GroupedOpenApi.builder().group("external")
                .packagesToScan(packagesToscan).build();
    }
}
