/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Check;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valoracion")
    @Check(constraints = "valoracion >= 1 AND valoracion <= 5")
    private int valoracion;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne()//cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne()
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Comentario() {
    }

    public Comentario(int valoracion, String comentario) {
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    public Comentario(int valoracion, String comentario, Persona persona, Libro libro) {
        this.valoracion = valoracion;
        this.comentario = comentario;
        this.persona = persona;
        this.libro = libro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
