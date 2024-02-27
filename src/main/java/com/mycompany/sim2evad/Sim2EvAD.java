/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sim2evad;

import com.mycompany.sim2evad.imp.LibroDAOimp;
import com.mycompany.sim2evad.imp.PersonaDAOimp;
import com.mycompany.sim2evad.model.Comentario;
import com.mycompany.sim2evad.model.Leer;
import com.mycompany.sim2evad.model.Libro;
import com.mycompany.sim2evad.model.Persona;
import com.mycompany.sim2evad.services.PersonaServices;
import java.util.ArrayList;

/**
 *
 * @author jacqueline
 */
public class Sim2EvAD {

    public static void main(String[] args) {
        PersonaServices ps = new PersonaServices();
        LibroDAOimp ldao = new LibroDAOimp();
        PersonaDAOimp pdao = new PersonaDAOimp();

        Persona p1 = new Persona("Pepe", "pep", "p@gmail", "123");
        Persona p2 = new Persona("Juan", "j", "j@gmail", "123");
        Persona p3 = new Persona("Luis", "luis", "l@gmail", "123");
        Persona p4 = new Persona("Luis", "luis", "l@gmail", "012");
        ps.create(p1);
        ps.create(p2);
        ps.create(p3);

        Libro l1 = new Libro("libro1", 10);
        Libro l2 = new Libro("libro2", 10);
        Libro l3 = new Libro("libro3", 10);
        ldao.createLibro(l1);
        ldao.createLibro(l2);
        ldao.createLibro(l3);

        ps.addLibroEscrito(p3, l2);
        ps.addLibroEscrito(p3, l3);
        Comentario c1 = new Comentario(2, "comentario1");
        Comentario c2 = new Comentario(5, "comentario2");
        ps.addLibroComentado(p1, l1, c1);
        ps.addLibroComentado(p1, l3, c2);

        ps.addLibroLeido(p1, l1);
        ps.addLibroLeido(p1, l2);
        ps.addLibroLeido(p1, l3);
        ps.addLibroLeido(p2, l1);
        ps.addLibroLeido(p2, l2);
//        ps.addLibroLeido(p2, l3);
        ps.addLibroLeido(p3, l1);
        ps.addLibroLeido(p3, l2);
        ps.addLibroLeido(p3, l3);

        ps.remove(p3);
//        
        if (ps.login(p2)) {
            Leer l= new Leer(p2);
            System.out.println("Bienvenido");
            System.out.println("Libros leidos: ");
            for (Libro libro : pdao.getLibrosLeidosByPersona(p2, l)) {
                System.out.println("--------libros leidos: "+ libro);
            }

            System.out.println("listado de libros: ");
            for (Libro libro : ldao.getLibros()) {
                System.out.println(libro);
            }
        } else {
            System.out.println("Usuario y/o contraseña invalido");
        }

    }

}
