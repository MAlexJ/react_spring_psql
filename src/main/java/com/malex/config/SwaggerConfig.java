package com.malex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.malex.constant.Constant.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Additional info
     */
    private ApiInfo apiInfo()
    {
        final ApiInfoBuilder builder = new ApiInfoBuilder();
        return builder
                .title(SWAGGER_TITLE)
                .version(SWAGGER_VERSION)
                .description(SWAGGER_DESCRIPTION)
                .build();
    }
}