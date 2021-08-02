package io.gustavo.starwars.configuration;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerConfiguration {

	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
				.select()                                  
				.apis(apis())              
				.paths(PathSelectors.any())                          
				.build()
				.apiInfo(apiInfo());                                           
	}
	
	private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("io.gustavo.starwars.controller");
    }

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfoBuilder()
				.title ("Star Wars Social Network API")
				.description ("Essa é a API de uma rede social fictícia de Star Wars.")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.version("1.0.0")
				.build();

		return apiInfo;
	}
}
