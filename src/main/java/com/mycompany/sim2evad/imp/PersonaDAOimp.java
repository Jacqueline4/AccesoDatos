/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.imp;

import com.mycompany.sim2evad.DAO.PersonaDAO;
import com.mycompany.sim2evad.HibernateUtil;
import com.mycompany.sim2evad.model.Comentario;
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
public class PersonaDAOimp implements PersonaDAO {

    @Override
    public void remove(Persona p) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (p.getId() != 0) {
                session.remove(p);
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
    public Persona get(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
            Root<Persona> personaTable = query.from(Persona.class);
            query.where(cb.equal(personaTable, id));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public void update(Persona p) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (p.getId() != 0) {
                session.merge(p);
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
    public void create(Persona p) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public Persona getByUser(Persona p) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
            Root<Persona> personaTable = query.from(Persona.class);
            query.where(cb.equal(personaTable.get("user"), p.getUser()));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Libro> getLibrosLeidos(Persona p) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
            Root<Libro> libroTable = query.from(Libro.class);
            Join<Libro, Persona> personaTable = libroTable.join("readersList");
            query.where(cb.equal(personaTable, p));
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public List<Libro> getLibrosEscritos(Persona p) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
            Root<Libro> libroTable = query.from(Libro.class);
            Join<Libro, Persona> personaTable = libroTable.join("writersList");
            query.where(cb.equal(personaTable, p));
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public List<Libro> getLibrosComentados(Persona p) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
            Root<Libro> libroTable = query.from(Libro.class);
            Join<Libro, Persona> personaTable = libroTable.join("commentsList");
            query.where(cb.equal(personaTable, p));      
            return session.createQuery(query).getResultList();
        }
    }
//    @Override
//    public List<Libro> getLibrosComentados(Persona p) {
//        try (Session session = HibernateUtil.getFactory().openSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Libro> query = cb.createQuery(Libro.class);
//            Root<Libro> libroTable = query.from(Libro.class);
//            Join<Libro, Comentario> comentarioTable = libroTable.join("commentsList");
//            Join<Comentario, Persona> personaTable = comentarioTable.join("usuario");
//            query.where(cb.equal(personaTable, p));
//            return session.createQuery(query).getResultList();
//        }
//    }

}
