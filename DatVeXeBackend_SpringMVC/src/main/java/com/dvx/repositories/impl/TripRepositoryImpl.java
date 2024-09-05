/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Route;
import com.dvx.pojo.Trip;
import com.dvx.repositories.TripRepository;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:configs.properties")
public class TripRepositoryImpl implements TripRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean Factory;


    @Override
    public List<Trip> findTripByRoute(Route r, Calendar d) {

        Session session = Factory.getObject().getCurrentSession();

        Query query = session.createQuery("FROM Trip  where routeId=:a and YEAR(departAt)=:y and MONTH(departAt)=:m "
                + "and DAY(departAt)=:d");
        query.setParameter("a", r);
        query.setParameter("y", d.get(Calendar.YEAR));
        query.setParameter("m", d.get(Calendar.MONTH) + 1);
        query.setParameter("d", d.get(Calendar.DATE));
        return query.getResultList();
    }

    @Override
    public List<Trip> getAllTrip(Map<String, String> params) {
        Session session = Factory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root<Trip> rootTrip = query.from(Trip.class);
        query.orderBy(builder.desc(rootTrip.get("id")));
        Query q = session.createQuery(query);
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                q.setMaxResults(pageSize);
                q.setFirstResult((p - 1) * pageSize);
            }else {
            q.setMaxResults(pageSize);
            q.setFirstResult(0);
        }
        }
        
        return q.getResultList();
    }

    @Override
    public Long countTrip() {
        Session session = Factory.getObject().getCurrentSession();

        Query query = session.createQuery("SELECT Count(*) FROM Trip");
        return Long.parseLong(query.getSingleResult().toString());
    }

    @Override
    public Trip getTripbyID(long id) {
        Session session = Factory.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Trip.findById");
        query.setParameter("id", id);
        return (Trip) query.getSingleResult();
    }

    @Override
    public boolean addOrUpdateTrip(Trip p) {
        Session s = Factory.getObject().getCurrentSession();
        try {
            if (p.getId() == null) {
                s.save(p);
            } else {
                s.update(p);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrip(long t) {
        
         Session s = Factory.getObject().getCurrentSession();
         try {
        
           s.delete(this.getTripbyID(t));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
