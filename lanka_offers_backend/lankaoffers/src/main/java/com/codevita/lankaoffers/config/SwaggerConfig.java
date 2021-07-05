package com.codevita.lankaoffers.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	Contact contact = new Contact(
			"CODEVITA PVT Ltd",
			"http://www.codevita.lk",
			"hello@codevita.lk"
			);
	
	@SuppressWarnings("rawtypes")
	List<VendorExtension> vendorExtension = new ArrayList<>();
	
	ApiInfo apiInfo = new ApiInfo(
			"LankaOffers.lk app RESTfull Web Service documentation",
			"This page documents LankaOffers.lk app RESTfukk Web Service endpoints",
			"1.0",
			"https://www.lankaoffers.lk/home.html",
			contact,
			"Apache 2.0", 
			"http://www.apache.org/licenses/LICENSE-2.0",
			vendorExtension);                                                       
	
	@Bean
	public Docket apiDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.codevita.lankaoffers"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

}
