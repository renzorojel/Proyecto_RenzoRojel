
package com.porftoliorr.mgb.Controler;

import com.porftoliorr.mgb.Entity.Persona;
import com.porftoliorr.mgb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService; 
    
@GetMapping("personas/traer")    
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
@PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada con exito";
    }
@DeleteMapping("/persona/borrar/ {id}")
    public String delatePersona(@PathVariable Long id){
        ipersonaService.delatePersona(id);
        return "La persoa fue borada con exito";
    }
@PutMapping("/persona/editar/(id)")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apeliido") String nuevoApellido,
            @RequestParam("img") String nuevoImg){
         Persona persona = ipersonaService.findPersona(id);
         persona.setNombre(nuevoNombre);
         persona.setApellido(nuevoApellido);
         persona.setImg(nuevoImg);
         
         ipersonaService.savePersona(persona);
         return persona;
    }
}

