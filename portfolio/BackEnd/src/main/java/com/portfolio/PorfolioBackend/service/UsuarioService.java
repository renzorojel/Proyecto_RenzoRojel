/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.service;

import com.portfolio.PorfolioBackend.model.Usuario;
import com.portfolio.PorfolioBackend.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    public UsuarioRepository usuarioRepository;
    
    @Autowired
    public IEncryptService encryptService;

    @Override
    public List<Usuario> obtenerUsuarios() {
        
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        
        String password = usuario.getContraseña();
        String hashPassword = encryptService.encryptPassword(password);
        usuario.setContraseña(hashPassword);
        usuarioRepository.save(usuario);
    }

}