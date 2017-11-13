package com.kzvance.httpdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
/*
 * http://localhost:8080/httpdemo/swagger-ui.htm
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${notes.hello}")
	String helloNotes;

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kzvance"))
				.paths(postPaths())
				.build();
	}
	
	@SuppressWarnings("unchecked")
	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/greeting.*"), regex("/hello.*"));
	}

	private ApiInfo apiInfo() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Spring Boot Sample API");
		apiInfoBuilder.description("kzvance Spring Boot testing api");
		apiInfoBuilder.contact(new Contact("kzvance", "BIS SharePoint", "kzvance@cox.com"));
		apiInfoBuilder.license("License of API");
		apiInfoBuilder.licenseUrl("API license URL");
		return apiInfoBuilder.build();
	}


}
