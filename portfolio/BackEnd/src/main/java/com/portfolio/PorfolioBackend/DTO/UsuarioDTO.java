/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.DTO;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


  @Getter @Setter
public class UsuarioDTO implements Serializable {
    
    private Long id;
    private String usuario;


    public UsuarioDTO(Long id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    
    }

    public UsuarioDTO() {
    }
}
  

