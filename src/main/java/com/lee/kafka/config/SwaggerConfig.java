package com.lee.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yz.li
 * @date 2018/4/25
 */
@Component
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lee.kafka.resource"))
                .paths(PathSelectors.any()).build()
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Kafka")
                .description("Kafka desc")
                .termsOfServiceUrl("")
                .contact(new Contact("yz.li", "", "liyz@cjzc.net.cn"))
                .version("1.0-SNAPSHOT").build();
    }
}
