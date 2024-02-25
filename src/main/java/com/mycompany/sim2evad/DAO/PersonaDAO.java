/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sim2evad.DAO;

import com.mycompany.sim2evad.model.Libro;
import com.mycompany.sim2evad.model.Persona;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public interface PersonaDAO {

    public void remove(Persona p);

    public Persona get(Long id);

    public void update(Persona p);

    public void create(Persona p);

    public Persona getByUser(Persona p);

    public List<Libro> getLibrosLeidos(Persona p);

    public List<Libro> getLibrosEscritos(Persona p);

    public List<Libro> getLibrosComentados(Persona p);
}
