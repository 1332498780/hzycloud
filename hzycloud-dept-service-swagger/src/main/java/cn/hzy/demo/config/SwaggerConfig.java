package cn.hzy.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.basePackage("cn.hzy.demo.rest"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("业务部门微服务").description("desc")
                .termsOfServiceUrl("serviceUrl")
                .contact(new Contact("hzy","url","@163.com"))
                .license("hzy").version("1.0").build();
    }
}
