
package com.portfolio.PorfolioBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;

@Getter
@Setter
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String ubicacion;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Persona(Long id, String nombre, String apellido, String email, String telefono, String ubicacion, Usuario usuario, Banner banner) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.usuario = usuario;

    }

    public Persona() {
    }
}
