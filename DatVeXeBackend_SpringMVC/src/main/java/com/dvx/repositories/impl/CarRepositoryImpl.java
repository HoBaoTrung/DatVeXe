/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Car;
import com.dvx.repositories.CarRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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

    @Override
    public int countCar(Map<String, String> params) {
//    Session s = this.sessionFactoryBean.getObject().getCurrentSession();
//        CriteriaBuilder builder = s.getCriteriaBuilder();
//        CriteriaQuery<Long> query = builder.createQuery(Long.class);
//        Root<Car> rootCar = query.from(Car.class);
//        Query q = null;
//        Predicate predicate;
//        
//        List<Predicate> predicates = new ArrayList<>();
//        String type = params.get("type");
//
//        if (type != null && !type.isEmpty() ){}
//                
//               
//            Types t = roleSer.getRoleByName("USER");
//
//            predicates.add(builder.equal(rootCar.get("roleId"), r));
//        } else {
//            Role r = roleSer.getRoleByName("STAFF");
//            predicates.add(builder.equal(rootUser.get("roleId"), r));
//        }
//
//        query.select(builder.count(rootUser)).where(builder.and(predicates.toArray(new Predicate[0])));
//
//        q = s.createQuery(query);
//
//        return (int) q.getSingleResult(); 
        return 123;
    }

    @Override
    public boolean addOrUpdateCar(Car c) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        try {

            if (c.getId() == null) {

                s.save(c);

            } else {
                s.update(c);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCar(long id) {
        Session s = sessionFactoryBean.getObject().getCurrentSession();
        try {
            s.delete(this.getById(id));
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
