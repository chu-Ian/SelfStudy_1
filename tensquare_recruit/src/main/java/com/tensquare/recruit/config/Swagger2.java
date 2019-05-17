package com.tensquare.recruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2 配置类
 * 通过@Configuration注解，让spring来加载该配置
 * 再通过@EnableSwagger2注解来启动Swagger2,
 * 注解springboot放在启动类上,tomcat就放在配置文件上
 */
@Configuration
public class Swagger2 {

    /**
     * 创建API应用
     * appinfo()增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例，用来控制那些接口暴露给Swagger来展现
     * 本例采用置顶扫描的包路径来定义指定要建立API的目录
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tensquare.recruit.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建改API的基本信息（这些基本信息会展示在文档页面中）
     * 访问地址： http://项目实际地址：项目实际端口/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("recruit-招聘服务数据接口")
                .description("招聘服务数据接口")
                .termsOfServiceUrl("www.123.com")
                .contact("cwj")
                .version("1.0")
                .build();
    }

}
