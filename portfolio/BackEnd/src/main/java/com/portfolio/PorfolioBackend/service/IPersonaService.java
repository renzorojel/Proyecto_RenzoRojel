
package com.portfolio.PorfolioBackend.service;

import com.portfolio.PorfolioBackend.model.Persona;
import java.util.List;




public interface IPersonaService {
    //método para traer todas las personas
    public List<Persona> obtenerPersonas ();
    
    //método para encontrar una persona por el Id
    public Persona obtenerPersona(Long id);  
    
    //método para editar una persona
    public void crearPersona (Persona perso);

    
    
}