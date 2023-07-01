/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.PorfolioBackend.service;

public interface IEncryptService {
    
    // este método recibe la contraseña que el usuario ingresa, y va a devolver la contraseña encriptada
    public String encryptPassword (String password);
 
}
