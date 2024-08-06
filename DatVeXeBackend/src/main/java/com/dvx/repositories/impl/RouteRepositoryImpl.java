/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Route;
import com.dvx.pojo.Station;
import com.dvx.repositories.RouteRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Route> getAllRoute() {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Route.findAll");
        return query.getResultList();
    }

    @Override
    public Route findById(Long id) {
         Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query query = s.createNamedQuery("Route.findById");
        query.setParameter("id", id);
        return (Route) query.getSingleResult();
    }

}
