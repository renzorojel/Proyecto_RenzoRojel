/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.security;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
    
    // inyectamos estas dependencias a través del constructor, el cual se genera con todos los argumentos mediante la anotación @AllArgsConstructor
    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;  
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        
        
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");  // esta va a ser la ruta para el login
        
        http.cors().and().csrf().disable().authorizeHttpRequests((authorize) -> {
            try {
                authorize
                        .requestMatchers("/obtener/**", "/enviarmail","/swagger-ui/**", "/v3/**")
                        .permitAll()  // todas las request que empiecen con obtener (todos los GET) no requieren token
                        .requestMatchers("/editar/**", "/crear/**", "/eliminar/**", "/subir/archivo")
                        .authenticated() // todas las request que empiecen con editar, eliminar o crear están protegidas, requieren un token (todos los PUT, DELETE y POST)
                        .anyRequest()
                        .denyAll()
                        .and()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .addFilter(jwtAuthenticationFilter)
                        .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
            } catch (Exception ex) {
                Logger.getLogger(WebSecurityConfig.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        );
	return http.build();
    }
    
    // para verificar la contraseña ingresada (el texto plano es encriptado y contrastado con el que está en la bbdd)
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }    

//    public static void main(String [] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("ArgentinaPrograma"));
//    }
}