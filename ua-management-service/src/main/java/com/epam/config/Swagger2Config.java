package com.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

//@Configuration
//@EnableSwagger2
public class Swagger2Config {

    /**
     * Method to set paths to be included through swagger
     *
     * @return Docket
     */
    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
                .paths(regex("/api.*")).build();
    }


    /**
     * Method to set swagger info
     *
     * @return ApiInfoBuilder
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("").description("").version("1.0").build();
    }
}