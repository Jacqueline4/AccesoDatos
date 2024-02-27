/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sim2evad.DAO;

import com.mycompany.sim2evad.model.Comentario;
import com.mycompany.sim2evad.model.Escribir;
import com.mycompany.sim2evad.model.Leer;
import com.mycompany.sim2evad.model.Libro;
import com.mycompany.sim2evad.model.Persona;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public interface LibroDAO {

    public void removeLibro(Libro l);

    public List<Libro> getLibros();

    public void updateLibro(Libro l);

    public void createLibro(Libro l);

    public Libro getByLibro(Libro l);
    
    public List<Persona> getLibrosLeidos(Libro l, Leer leer);

    public List<Persona> getLibrosEscritos(Libro l, Escribir e);

    public List<Persona> getLibrosComentados(Libro l, Comentario c);
}
