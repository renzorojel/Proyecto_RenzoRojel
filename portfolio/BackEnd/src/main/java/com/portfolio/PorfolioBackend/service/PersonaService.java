
package com.portfolio.PorfolioBackend.service;

import com.portfolio.PorfolioBackend.model.Persona;
import com.portfolio.PorfolioBackend.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    public PersonaRepository persoRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return persoRepository.findAll();
    }

    @Override
    public Persona obtenerPersona(Long id) {
        return persoRepository.findById(id).orElse(null);
    }

    @Override
    public void crearPersona(Persona perso) {         
        
        persoRepository.save(perso);
    }
}