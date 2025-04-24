package com.MemberPortal.MemberPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class MemberPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberPortalApplication.class, args);
	}
	
	@Bean
    public Docket configureSwagger() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.ant("//*"))
                .apis(RequestHandlerSelectors.basePackage("com.MemberPortal.MemberPortal.controller")).build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo("USers Api", "Sample API for users", "1.0", "path/to/terms",
                new Contact("Abdul Mohi ", "http://www.google.com", "abdulmohi2603@gmail.com"), "API License",
                "http://www.google.com", Collections.emptyList());
    }

}
