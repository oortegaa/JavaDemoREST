/**
 * 
 */
package com.wizeline.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Set API documentation with Swagger
 * @author oortegaa
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wizeline.demo.controller"))
				.paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(getApiInfo());

	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Demo REST Services Wizeline")
	            .description("REST Service Description")
	            .contact(new Contact("Alejandro Ortiz", "https://www.linkedin.com/in/alejandro-ortiz-ortega/", "oortegaa@gmail.com"))
	            .license("(C) License.")
	            .licenseUrl("Licence URL")
	            .version("1.0")
	            .build();
	    }
}
