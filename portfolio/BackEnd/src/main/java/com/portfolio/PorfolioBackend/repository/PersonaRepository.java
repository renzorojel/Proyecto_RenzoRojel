
package com.portfolio.PorfolioBackend.repository;

import com.portfolio.PorfolioBackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
