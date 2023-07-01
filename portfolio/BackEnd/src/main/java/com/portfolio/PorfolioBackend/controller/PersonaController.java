/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PorfolioBackend.controller;

import com.portfolio.PorfolioBackend.model.Persona;
import com.portfolio.PorfolioBackend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    public IPersonaService personaService;
    
    @GetMapping ("/obtener/personas")
    public List <Persona> obtenerPersonas () {        
        
        return personaService.obtenerPersonas();
    }
    
    @GetMapping ("/obtener/persona/{id}")
    public Persona obtenerPersona (@PathVariable Long id) {
        
        return personaService.obtenerPersona(id);
        
    }
    
    @PutMapping ("/editar/persona/{id}")
    public void editarPersona (@PathVariable Long id, 
                               @RequestBody Persona persona) {
        
        
        persona.setId(id);
        
               
        personaService.crearPersona(persona);         
        
    }
    
    @PostMapping ("/crear/persona")
    public void crearPersona (@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }
}