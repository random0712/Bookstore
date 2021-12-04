package com.patrickamaro.bookstoremanager.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String API_TITLE = "Bookstore Manager Course";
    private static final String API_DESCRIPTION = "Bookstore Manager API Professional";
    private static final String API_VERSION = "1.0.0";
    private static final String AUTHOR_NAME = "Patrick Amaro Barbosa";
    private static final String AUTHOR_GITHUB = "https://github.com/random0712";
    private static final String AUTHOR_EMAIL = "patrickamaro9@gmail.com";


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(API_TITLE)
                        .description(API_DESCRIPTION)
                        .version(API_VERSION)
                        .contact(new Contact()
                                .name(AUTHOR_NAME)
                                .email(AUTHOR_EMAIL)
                                .url(AUTHOR_GITHUB)
                        ));
    }
}
