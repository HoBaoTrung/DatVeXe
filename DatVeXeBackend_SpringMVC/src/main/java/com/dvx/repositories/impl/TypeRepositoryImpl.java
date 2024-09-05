/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Types;
import com.dvx.repositories.TypeRepository;
import java.util.List;
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
public class TypeRepositoryImpl implements TypeRepository {

    @Autowired
    private LocalSessionFactoryBean Factory;

    @Override
    public List<Types> getAllType() {
        Session session = Factory.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Types.findAll");
        return query.getResultList();
    }

    @Override
    public Types getTypeByName(String name) {
        Session session = Factory.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Types.findByName");
        query.setParameter("name", name);
        return (Types) query.getSingleResult();
    }

    @Override
    public Types getTypeById(Long id) {
        Session session = Factory.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Types.findById");
        query.setParameter("id", id);
        return (Types) query.getSingleResult();
    }

    @Override
    public boolean addOrUpdate(Types t) {
        Session s = this.Factory.getObject().getCurrentSession();
        try {

            if (t.getId() == null) {

                s.save(t);

            } else {
                s.update(t);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteType(long id){
    Session s = Factory.getObject().getCurrentSession();
        try {
            s.delete(this.getTypeById(id));
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}


