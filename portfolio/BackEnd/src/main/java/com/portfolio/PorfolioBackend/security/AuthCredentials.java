/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.security;

import lombok.Data;


@Data
public class AuthCredentials {
    private String usuario;
    private String contraseña;
}