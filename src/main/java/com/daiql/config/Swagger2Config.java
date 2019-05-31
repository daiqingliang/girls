package com.daiql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/5/31 11:39 AM
 * @Version: 1.0
 */
@Configuration //说明当前类是配置类
@EnableSwagger2 //开始swagger2的使用
public class Swagger2Config {
    @Bean
    public Docket buildDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面apiInfo()方法
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.daiql.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("springboot结合swagger2构建Restful API")
                .description("这是一个swagger2小型demo")
                .termsOfServiceUrl("localhost:8080")
                .version("0.0.1")
                .build();

    }
}
