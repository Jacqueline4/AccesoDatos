/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.services;

import com.mycompany.sim2evad.imp.PersonaDAOimp;
import com.mycompany.sim2evad.model.Libro;
import com.mycompany.sim2evad.model.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public class PersonaServices {

    PersonaDAOimp pdao = new PersonaDAOimp();

    public boolean login(Persona p) {
        Persona dbPesona = pdao.getByUser(p);
        if (dbPesona != null) {
            if (p.getUser().equals(dbPesona.getUser()) && p.getPassword().equals(dbPesona.getPassword())) {
                return true;
            }
        }
        return false;
    }

//    public void addLibroLeido(Persona p, Libro l) {
//        p.getReadList().add(l);
//        l.getReadersList().add(p);
//        pdao.update(p);
//    }
    public void addLibroLeido(Persona p, Libro l) {
        List<Libro> dbll = pdao.getLibrosLeidos(p);
        if (!dbll.contains(l)) {
            p.getReadList().add(l);
        }
        if (!l.getReadersList().contains(p)) {
            l.getReadersList().add(p);
        }
        pdao.update(p);
    }

    public void addLibroEscrito(Persona p, Libro l) {
        p.getWriteList().add(l);
        l.getWritersList().add(p);
        pdao.update(p);
    }

    public void addLibroComentado(Persona p, Libro l) {
        p.getCommentList().add(l);
        l.getCommentsList().add(p);
        pdao.update(p);
    }

    public void remove(Persona p) {
        pdao.remove(p);
    }

    public void create(Persona p) {

        pdao.create(p);
    }

}
