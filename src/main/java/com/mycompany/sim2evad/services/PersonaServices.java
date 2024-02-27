/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.services;

import com.mycompany.sim2evad.imp.LibroDAOimp;
import com.mycompany.sim2evad.imp.PersonaDAOimp;
import com.mycompany.sim2evad.model.Comentario;
import com.mycompany.sim2evad.model.Escribir;
import com.mycompany.sim2evad.model.Leer;
import com.mycompany.sim2evad.model.Libro;
import com.mycompany.sim2evad.model.Persona;

/**
 *
 * @author jacqueline
 */
public class PersonaServices {

    PersonaDAOimp pdao = new PersonaDAOimp();
    LibroDAOimp ldao = new LibroDAOimp();

    public boolean login(Persona p) {
        Persona dbPesona = pdao.getByPersona(p);
        if (dbPesona != null) {
            if (p.getUser().equals(dbPesona.getUser()) && p.getPassword().equals(dbPesona.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void addLibroLeido(Persona p, Libro l) {
        Persona pdb = pdao.getByPersona(p);
        Libro ldb = ldao.getByLibro(l);
        pdb.getReadList().add(new Leer(ldb, pdb));

        pdao.update(pdb);
    }

    public void addLibroEscrito(Persona p, Libro l) {
        Persona pdb = pdao.getByPersona(p);
        Libro ldb = ldao.getByLibro(l);
        pdb.getWriteList().add(new Escribir(ldb, pdb));
        pdao.update(pdb);
    }

    public void addLibroComentado(Persona p, Libro l, Comentario c) {

        Persona pdb = pdao.getByPersona(p);
        Libro ldb = ldao.getByLibro(l);
        c.setLibro(ldb);
        c.setPersona(pdb);
        pdb.getCommentList().add(c);
        ldb.getCommentsList().add(c);

        pdao.update(pdb);
    }

    public void remove(Persona p) {
        Persona pdb = pdao.getByPersona(p);
        pdao.remove(pdb);
    }

    public void create(Persona p) {
        
        pdao.create(p);
    }

    public void update(Persona p) {
        Persona pdb = pdao.getByPersona(p);
        pdao.update(pdb);
    }
}
