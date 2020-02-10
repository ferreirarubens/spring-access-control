package com.ferreirarubens.accesscontrol.common.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	final String CLIENT_ID = "coderef";
	final String CLIENT_SECRET = "secret";
	
	@Value("${auth-server.hostname}")
	private String authServer;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()// <4>
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build().apiInfo(apiInfo())
				.securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()));
                
	}
	
	@Bean
	  UiConfiguration uiConfig() {
	    return UiConfigurationBuilder.builder()
	        .docExpansion(DocExpansion.LIST)
	        .build();
	  }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ACCESS CONTROL API").description("Access Control Cloud Management REST API")
				.contact(new Contact("Rubens Ferreira", "https://github.com/ferreirarubens",
						"rubensdefrancaferreira@gmail.com"))
				.version("0.0.1").build();
	}

	private ApiKey apiKey() {
		return new ApiKey("apiKey", "Authorization", "header");
	}

	private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/api.*"))
                .build();
    }
	
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope[] scopes = { 
			      new AuthorizationScope("read", "for read operations"), 
			      new AuthorizationScope("write", "for write operations")
		};
        return Arrays.asList(new SecurityReference("apiKey", scopes));
    }
	
	@Bean
    public SecurityConfiguration securityInfo() {
        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator("")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

	/*
	 private AuthorizationScope[] scopes() {
	    AuthorizationScope[] scopes = { 
	      new AuthorizationScope("read", "for read operations"), 
	      new AuthorizationScope("write", "for write operations"), 
	      new AuthorizationScope("foo", "Access foo API") };
	    return scopes;
	}
	 
	 @Bean
	public SecurityConfiguration security() {
	    return SecurityConfigurationBuilder.builder()
	        .clientId(CLIENT_ID)
	        .clientSecret(CLIENT_SECRET)
	        .scopeSeparator(" ")
	        .useBasicAuthenticationWithAccessCodeGrant(true)
	        .build();
	}
	
	private AuthorizationScope[] scopes() {
	    AuthorizationScope[] scopes = { 
	      new AuthorizationScope("read", "for read operations"), 
	      new AuthorizationScope("write", "for write operations")
	    };
	    return scopes;
	}
	
	private SecurityScheme securityScheme() {
	    GrantType grantType = new AuthorizationCodeGrantBuilder()
	        .tokenEndpoint(new TokenEndpoint(authServer + "/oauth/authorize", "access_token"))
	        .tokenRequestEndpoint(
	          new TokenRequestEndpoint("http://localhost:4200" + "/login", CLIENT_ID, CLIENT_SECRET))
	        .build();
	 
	    SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
	        .grantTypes(Arrays.asList(grantType))
	        .scopes(Arrays.asList(scopes()))
	        .build();
	    return oauth;
	}
	
	private SecurityContext securityContext() {
      return SecurityContext.builder()
              .securityReferences(Arrays.asList(new SecurityReference("apiKey", scopes())))
              .forPaths(PathSelectors.regex("/api.*"))
              .build();
  }*/
}