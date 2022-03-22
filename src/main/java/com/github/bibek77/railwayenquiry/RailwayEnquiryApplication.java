package com.github.bibek77.railwayenquiry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SpringBootApplication
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RailwayEnquiryApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RailwayEnquiryApplication.class, args);
        log.info("Spring Boot RailwayEnquiry Application is Launched");

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(RailwayEnquiryApplication.class);
    }

}
