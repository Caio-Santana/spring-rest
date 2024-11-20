package com.samsoftware.quickpoll.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("QuickPoll REST API")
                        .description("QuickPoll Api for creating and managing polls")
                        .version("1.0")
                        .contact(new Contact()
                                .name("John Doe")
                                .email("info@example.com")
                        )
                        .termsOfService("http://example.com/terms-of-service\\")
                        .license(new License()
                                .name("MIT License")
                                .url("http://opensource.org/licenses/MIT")
                        )
                );
    }
}
