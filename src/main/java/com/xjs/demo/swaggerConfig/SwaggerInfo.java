package com.xjs.demo.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerInfo {

    //接口版本号
    private final String version = "1.0";
    //接口大标题
    private final String title = "SpringBoot示例";
    //详细描述
    private final String description = "API接口自动生成示例";
    //服务地址
    private final String termsOfServiceUrl = "http://www.kingeid.com";

    // licence
    private final String license = "MIT";
    // licnce url
    private final String licenseUrl = "https://mit-license.org/";
    // 接口作者联系方式
    private final Contact contact = new Contact("calebman", "https://github.com/xuanjinsheng", "961692500@qq.com");

    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select().build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title(title).
                termsOfServiceUrl(termsOfServiceUrl).description(description).
                version(version).license(license).licenseUrl(licenseUrl).contact(contact).build();
    }

}
