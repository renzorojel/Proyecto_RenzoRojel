
package com.portfolio.PorfolioBackend.service;

import com.portfolio.PorfolioBackend.model.Persona;
import java.util.List;




public interface IPersonaService {
    
    public List<Persona> verPersonas ();
    public void crearPersona (Persona per);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);   

    public List<Persona> verPersona();
    
    
    
}
