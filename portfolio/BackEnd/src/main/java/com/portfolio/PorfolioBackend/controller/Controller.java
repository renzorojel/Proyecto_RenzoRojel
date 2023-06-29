
package com.portfolio.PorfolioBackend.Controller;

import com.portfolio.PorfolioBackend.model.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
   
    List<Persona> listaPersonas = new ArrayList();
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers){
        listaPersonas.add(pers);
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas (){
        return listaPersonas;
    }
}
