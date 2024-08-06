/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Car;
import com.dvx.repositories.CarRepository;
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
public class CarRepositoryImpl implements CarRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public List<Car> getAllCar() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        return session.createQuery("FROM Car", Car.class).list();
    }

    @Override
    public Car getById(long id) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createNamedQuery("Car.findById");
        q.setParameter("id", id);
        return (Car) q.getSingleResult();
    }

}
