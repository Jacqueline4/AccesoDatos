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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "comentados", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "libro_id","valoracion", "comentario"})
})
public class Comentario {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Persona usuario;

     @ManyToMany(mappedBy = "writeList")
    private List<Persona> List = new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name = "libro_id")
//    private Libro libro;

    @Column(name = "valoracion")
    private int valoracion;

    @Column(name = "comentario")
    private String comentario;

    public Comentario() {
    }

    public Comentario(int valoracion, String comentario) {
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }
//
//    public Libro getLibro() {
//        return libro;
//    }
//
//    public void setLibro(Libro libro) {
//        this.libro = libro;
//    }

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
    
}
