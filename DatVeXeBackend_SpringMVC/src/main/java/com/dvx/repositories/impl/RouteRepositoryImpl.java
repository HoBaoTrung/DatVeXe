/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Route;
import com.dvx.pojo.Station;
import com.dvx.repositories.RouteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class RouteRepositoryImpl implements RouteRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    
    @Autowired
    private Environment env;
    
    @Override
    public Route findRoute(Map<String, String> params) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Station.findById");
        Station from = (Station) query.setParameter("id", Long.parseLong(params.get("from"))).getSingleResult();
        Station to = (Station) query.setParameter("id", Long.parseLong(params.get("to"))).getSingleResult();
        
        Query q = s.createQuery("From Route where fromStation=:a and toStation=:b");
        q.setParameter("a", from);
        q.setParameter("b", to);
        return (Route) q.getSingleResult();
    }
    
    @Override
    public List<Route> getAllRoute(Map<String, String> params) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Route.findAll");
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
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
    public long countRoute(Map<String, String> params) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Route> rootUser = query.from(Route.class);
        javax.persistence.Query q = null;
        List<Predicate> predicates = new ArrayList<>();
        
        query.select(builder.count(rootUser)).where(builder.and(predicates.toArray(new Predicate[0])));
        
        q = s.createQuery(query);
        
        return (long) q.getSingleResult();
    }
    
    @Override
    public Route findById(Long id) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Route.findById");
        query.setParameter("id", id);
        return (Route) query.getSingleResult();
    }
    
    @Override
    public boolean addOrUpdateRoute(Route route) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            
            if (route.getId() == null) {
                
                s.save(route);
                
            } else {
                s.update(route);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteRoute(long id) {
        Session s = sessionFactoryBean.getObject().getCurrentSession();
        try {
            s.delete(this.findById(id));
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}


