/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.PorfolioBackend.service;

import com.portfolio.PorfolioBackend.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public List<Usuario> obtenerUsuarios();
    
    public Usuario obtenerUsuario(Long id);   
    
    public void crearUsuario(Usuario usuario);
     
}