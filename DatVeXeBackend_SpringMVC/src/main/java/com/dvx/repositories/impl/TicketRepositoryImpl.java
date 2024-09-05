/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Orders;
import com.dvx.pojo.Ticket;
import com.dvx.repositories.TicketRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private Environment env;

    @Override
    public Ticket getById(long id) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createNamedQuery("Ticket.findById");
        q.setParameter("id", id);
        return (Ticket) q.getSingleResult();
    }

    @Override
    public boolean deleteTicket(long id) {
        Session s = sessionFactoryBean.getObject().getCurrentSession();
        try {
            s.delete(this.getById(id));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addOrUpdateTicket(Ticket u) {
        Session s = sessionFactoryBean.getObject().getCurrentSession();
        try {

            if (u.getId() == null) {

                s.save(u);

            } else {
                s.update(u);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Ticket> getByOrder(Orders o) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();

        CriteriaQuery<Ticket> query
                = builder.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("orderId"), o));
        query.where(predicates.toArray(new Predicate[0]));
        Query q = s.createQuery(query);
        return q.getResultList();
    }

}
