
package com.porftoliorr.mgb.Service;

import com.porftoliorr.mgb.Entity.Persona;
import com.porftoliorr.mgb.Interface.IPersonaService;
import com.porftoliorr.mgb.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpmPersonaService implements IPersonaService{
    
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
                return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void delatePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id) .orElse(null);
                return persona;
    }
    
}
