/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sim2evad.imp;

import com.mycompany.sim2evad.DAO.LibroDAO;
import com.mycompany.sim2evad.HibernateUtil;
import com.mycompany.sim2evad.model.Libro;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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

}
