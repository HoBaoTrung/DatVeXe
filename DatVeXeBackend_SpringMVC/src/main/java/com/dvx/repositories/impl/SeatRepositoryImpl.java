/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Seat;
import com.dvx.pojo.Station;
import com.dvx.repositories.SeatRepository;
import com.dvx.repositories.StationRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
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
public class SeatRepositoryImpl implements SeatRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public Seat getSteatsByID(long id) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createNamedQuery("Seat.findById");
        q.setParameter("id", id);
        return (Seat) q.getSingleResult();
    }

}
