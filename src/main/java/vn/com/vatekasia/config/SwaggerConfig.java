package vn.com.vatekasia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("vn.com.vatekasia.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swapper API")
                .description("Hotel manager")
                .termsOfServiceUrl("http://localhost:8081/swagger-ui.html")
                .licenseUrl("hotel@gmail.com")
                .version("1.0")
                .build();
    }
}
