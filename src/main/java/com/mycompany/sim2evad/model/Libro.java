/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Escribir> writersList = new ArrayList<>();

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Leer> readersList = new ArrayList<>();

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comentario> commentsList = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Libro -> " + "id=" + id + ", title=" + title + ", paginas=" + paginas;
    }

    public List<Comentario> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comentario> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Escribir> getWritersList() {
        return writersList;
    }

    public void setWritersList(List<Escribir> writersList) {
        this.writersList = writersList;
    }

    public List<Leer> getReadersList() {
        return readersList;
    }

    public void setReadersList(List<Leer> readersList) {
        this.readersList = readersList;
    }

}
