/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;
    
    @Column(name = "numero_paginas")
    private int paginas;

    @ManyToMany(mappedBy = "writeList")
    private List<Persona> writersList = new ArrayList<>();
    
    @ManyToMany(mappedBy = "readList")
    private List<Persona> readersList = new ArrayList<>();
    
    @ManyToMany(mappedBy = "commentList")
    private List<Persona> commentsList = new ArrayList<>();

    public Libro() {
    }

    public Libro(String title, int paginas) {
        this.title = title;
        this.paginas = paginas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public List<Persona> getWritersList() {
        return writersList;
    }

    public void setWritersList(List<Persona> writersList) {
        this.writersList = writersList;
    }

    public List<Persona> getReadersList() {
        return readersList;
    }

    public void setReadersList(List<Persona> readersList) {
        this.readersList = readersList;
    }

    public List<Persona> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Persona> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "Libro: \n" + "id=" + id + ", title=" + title + ", paginas=" + paginas + ", writersList=" + writersList + 
                ", readersList=" + readersList + ", commentsList=" + commentsList;
    }
    
    
}
