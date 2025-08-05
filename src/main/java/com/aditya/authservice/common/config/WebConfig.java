package com.aditya.authservice.common.config;

import com.aditya.authservice.common.annotation.LogEntryExit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Override
    @LogEntryExit
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedOrigins("*");
    }

    @Override
    @LogEntryExit
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}
