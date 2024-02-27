/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.imp;

import com.mycompany.sim2evad.DAO.LibroDAO;
import com.mycompany.sim2evad.HibernateUtil;
import com.mycompany.sim2evad.model.Comentario;
import com.mycompany.sim2evad.model.Escribir;
import com.mycompany.sim2evad.model.Leer;
import com.mycompany.sim2evad.model.Libro;
import com.mycompany.sim2evad.model.Persona;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacqueline
 */
public class LibroDAOimp implements LibroDAO {

    @Override
    public void removeLibro(Libro l) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (l.getId() != 0) {
                session.remove(l);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public List<Libro> getLibros() {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
            Root<Libro> libroTable = query.from(Libro.class);
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public void updateLibro(Libro l) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (l.getId() != 0) {
                session.merge(l);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public void createLibro(Libro l) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(l);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    public Libro getByLibro(Libro l) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
            Root<Libro> libroTable = query.from(Libro.class);
            query.where(cb.equal(libroTable.get("id"), l.getId()));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Persona> getLibrosLeidos(Libro l, Leer leer) {
         try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
            Root<Persona> personaTable = query.from(Persona.class);
            Join<Persona, Comentario> lecturaTable = personaTable.join("readList");
            Join<Comentario, Libro> libroTable = lecturaTable.join("libro");
            query.where(cb.and(cb.equal(libroTable, l), cb.equal(lecturaTable, leer)));
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public List<Persona> getLibrosEscritos(Libro l,Escribir e) {
         try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
            Root<Persona> personaTable = query.from(Persona.class);
            Join<Persona, Escribir> escrituraTable = personaTable.join("writeList");
            Join<Escribir, Libro> libroTable = escrituraTable.join("libro");
            query.where(cb.and(cb.equal(libroTable, l), cb.equal(escrituraTable, e)));
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public List<Persona> getLibrosComentados(Libro l,Comentario c) {
       try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
            Root<Persona> personaTable = query.from(Persona.class);
            Join<Persona, Comentario> comentarioTable = personaTable.join("commentList");
            Join<Comentario, Libro> libroTable = comentarioTable.join("libro");
            query.where(cb.and(cb.equal(libroTable, l), cb.equal(comentarioTable, c)));
            return session.createQuery(query).getResultList();
        }
    }

}
