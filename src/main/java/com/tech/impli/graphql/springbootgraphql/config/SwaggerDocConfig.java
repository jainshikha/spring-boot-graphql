package com.javadeveloperzone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
@EnableSwagger2
public class SwaggerDocConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SwaggerDocConfig.class, args);            // it wil start application
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tech.impli.graphql.springbootgraphql.*"))  // // Generate API of EndPoints which is available inside defined package
                .paths(PathSelectors.any())   // for all EndPoints
                .build();             // create object
    }
}