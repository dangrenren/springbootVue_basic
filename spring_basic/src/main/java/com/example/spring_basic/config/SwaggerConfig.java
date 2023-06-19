package com.example.spring_basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.spring_basic.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("在奋斗的大道上 - 微信预约查档系统").termsOfServiceUrl("https://blog.csdn.net/zhouzhiwengang")
                .description("API接口")
                .contact(new Contact("https://blog.csdn.net/zhouzhiwengang", "", ""))
                .version("3.0").build();
    }

}
//swagger 访问页面 http://localhost:9090/swagger-ui/index.html#/
/**
 * Springfox 假设 Spring MVC 的路径匹配策略是 ant-path-matcher，
 * 而 Spring Boot 2.6.x及以后版本的默认匹配策略是 path-pattern-matcher，
 * 不修改会造成下方documentationPluginsBootstrapper报错。(在appliction.yaml里配置).
 * 但是好像在applicayion.yaml不是根治的方法
 * CSDN 原因解释链接 https://blog.csdn.net/weixin_49523761/article/details/122305980
 **/

