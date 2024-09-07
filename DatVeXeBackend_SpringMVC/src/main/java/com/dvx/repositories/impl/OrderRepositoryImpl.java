/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Car;
import com.dvx.pojo.Orders;
import com.dvx.pojo.User;
import com.dvx.repositories.CarRepository;
import com.dvx.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
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
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private Environment env;

    @Override
    public Orders getById(long id) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createNamedQuery("Order.findById");
        q.setParameter("id", id);
        return (Orders) q.getSingleResult();
    }

    @Override
    public Orders getByUserAndId(User user, long id) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> rootOrder = query.from(Orders.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootOrder.get("customerId"), user));
        predicates.add(builder.equal(rootOrder.get("id"), id));
        query.where(predicates.toArray(Predicate[]::new));
        Query q = s.createQuery(query);
        return (Orders) q.getSingleResult();
    }

    @Override
    public List<Orders> getByUser(User id) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> rootOrder = query.from(Orders.class);
        Predicate predicates = builder.equal(rootOrder.get("customerId"), id);
        query.where(predicates);
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Orders> getAllOrder(Map<String, String> params) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> rootOrder = query.from(Orders.class);
        Query q = null;
        List<Predicate> predicates = new ArrayList<>();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        query.where(predicates.toArray(new Predicate[0]));
        query.orderBy(builder.desc(rootOrder.get("id")));

        q = s.createQuery(query);

        String page = params.get("page");
        if (page != null && !page.isEmpty()) {
            int p = Integer.parseInt(page);

            q.setMaxResults(pageSize);
            q.setFirstResult((p - 1) * pageSize);
        } else {
            q.setMaxResults(pageSize);
            q.setFirstResult(0);
        }

        return q.getResultList();
    }

    @Override
    public int countOrder(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteOrder(long id) {
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
    public boolean addOrUpdateOrder(Orders u) {
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

}
