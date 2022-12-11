package br.edu.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**")
        .allowedOrigins("url_permitida") 
        .allowedMethods("POST", "PUT", "DELETE", "PATH", "GET", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
