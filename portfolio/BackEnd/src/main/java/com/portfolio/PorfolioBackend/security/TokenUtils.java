/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/**
 *
 * @author renzo
 */
public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "4329gkjrbjcndj23pqosoo33sdsdsd2322323sdsdsd232323sdsdsdsd"; // esta es la firma que vamos a usar para el token, 
                                                                                                                   // la cual no puede tener un tamaño menor a 256 bits, por eso la hice 
                                                                                                                   // súper larga ( por cierto la generè yo mismo escribiendo cualquier cosa)
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 86400L;  // duración del token en segundos (1 día)    
    
    // método para generar el token
    
    public static String createToken (String nombre) {  
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;  // tiempo para que el token expire
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre); // en el token va a figurar el nombre del usuario
        return Jwts.builder().setSubject(nombre) 
                .setExpiration(expirationDate)
                .addClaims(extra)     // acá hacemos que el nombre se agregue al token (se pueden poner tantos extra como uno quiera)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))   // generamos la firma con nuestra variable definida arriba
                .compact();
    }
    
    // método para retornar un usuario y contraseña de autenticación al usuario al ingresar el token
    
    public static UsernamePasswordAuthenticationToken getAuthentication (String token) {
        try {
            Claims claims = Jwts.parserBuilder()
           .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
           .build()
           .parseClaimsJws(token)
           .getBody();
        
        String nombre = claims.getSubject();
        
        return new UsernamePasswordAuthenticationToken(nombre, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }      
    }
}