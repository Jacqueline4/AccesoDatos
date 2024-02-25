/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sim2evad;

import com.mycompany.sim2evad.imp.LibroDAOimp;
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

        ldao.createLibro(l3);

        ps.addLibroEscrito(p3, l1);
        ps.addLibroEscrito(p3, l2);

        ps.addLibroLeido(p2, l1);

        ps.addLibroComentado(p2, l1);
        ps.addLibroComentado(p2, l3);
        ps.addLibroLeido(p1, l1);

        if (ps.login(p1)) {
            System.out.println("Bienvenido");
            /*System.out.println("Libros leidos: ");
           
            for (Libro libro :p1.getReadList() ) {
                System.out.println(libro);
            }
            System.out.println("listado de libros: ");
            for (Libro libro : ldao.getLibros()) {
                System.out.println(libro);
            }*/
        } else {
            System.out.println("Usuario y/o contraseña invalido");
        }
    }

}
