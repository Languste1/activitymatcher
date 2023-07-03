package com.example.actvitymatcher.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {


    // Cross-Origin Configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //This line sets the allowed origin(s) for cross-origin requests.
                registry.addMapping("/**")
                        //Allows Angular Frontend
                        .allowedOrigins("http://localhost:4200")
                        //This line specifies the allowed HTTP methods for cross-origin requests
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        //enables support for credentials in the requests.
                        .allowCredentials(true);
            }
        };
    }
}
