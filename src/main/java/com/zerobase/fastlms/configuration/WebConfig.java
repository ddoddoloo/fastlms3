package com.zerobase.fastlms.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // files 아래의 리소스에 대한 요청을 매핑.
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:./files/");
    }
}