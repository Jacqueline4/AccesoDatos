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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "usuario")
    private String user;

    @Column(name = "correo")
    private String mail;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "last_time_login")
    private LocalDateTime lastTimeLogin;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Escribir> writeList = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Leer> readList = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comentario> commentList = new ArrayList<>();

    public Persona() {
    }

    public Persona(String name, String user, String mail, String password) {
        this.name = name;
        this.user = user;
        this.mail = mail;
        this.password = password;
        this.lastTimeLogin =LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Persona -> " + "id=" + id + ", name=" + name + ", user=" + user + ", mail=" + mail;
    }

    public List<Comentario> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comentario> commentList) {
        this.commentList = commentList;
    }

    public List<Escribir> getWriteList() {
        return writeList;
    }

    public void setWriteList(List<Escribir> writeList) {
        this.writeList = writeList;
    }

    public List<Leer> getReadList() {
        return readList;
    }

    public void setReadList(List<Leer> readList) {
        this.readList = readList;
    }

}
