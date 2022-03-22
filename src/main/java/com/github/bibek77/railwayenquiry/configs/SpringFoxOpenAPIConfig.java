package com.github.bibek77.railwayenquiry.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bibek
 */
@Configuration
public class SpringFoxOpenAPIConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .packagesToScan("com.github.bibek77.railwayenquiry.request.controller")
                .group("public-apis")
                .build();
    }

    @Bean
    public OpenAPI springOpenAPIInfo() {
        return new OpenAPI()
                .info(new Info().title("Railway Enquiry Application")
                        .description("Spring Boot Application to enquire Train Status and PNR Status")
                        .version("1.0"));

    }

}
