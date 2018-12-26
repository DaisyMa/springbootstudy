package com.myl.test.springbootstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //springboot 加载配置文件
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select().paths(PathSelectors.regex("/.*")).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("test api")
                .contact(new Contact("daisy","","ma.yanli@centchain.com"))
                .description("这是swagger-ui生成的文档 ")
                .version("1.0")
                .build();
    }

}
