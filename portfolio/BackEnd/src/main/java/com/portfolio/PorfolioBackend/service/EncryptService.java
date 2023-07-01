/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptService implements IEncryptService {
    
    @Override
    public String encryptPassword(String password) {
        
        // encriptamos la contraseña original            
        return new BCryptPasswordEncoder().encode(password);
    }  
}
