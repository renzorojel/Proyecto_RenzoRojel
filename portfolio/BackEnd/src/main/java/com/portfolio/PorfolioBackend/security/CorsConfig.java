/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // acá establecemos la url cuyo cors vamos a configurar, en este caso serían todas
                        .allowedOrigins("*")    // acá establecemos cuáles son los orígenes que van a estar autorizados, ponemos todos
                        .allowedMethods("*")    // acá establecemos los métodos que se van a permitir, vuelve a ser todos
                        .exposedHeaders("*");   // con esto autorizamos que el navegador pueda acceder y guardar en su cache todos los headers de la respuesta (esto lo hacemos 
                                                       // para poder acceder al token, que está en el header)         
            }
        };
    }

}