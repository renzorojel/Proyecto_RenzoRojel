
package com.porftoliorr.mgb.Interface;

import com.porftoliorr.mgb.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //traer persona
    public List<Persona>getPersona() ;  
    // guardar 
    public void savePersona(Persona persona ) ;
    
    public void delatePersona(Long id) ;
    
    public Persona findPersona(Long id);
}
