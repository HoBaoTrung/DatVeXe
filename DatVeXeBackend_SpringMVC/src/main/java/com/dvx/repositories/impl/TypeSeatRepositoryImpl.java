/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Types;
import com.dvx.pojo.TypesSeat;
import com.dvx.repositories.TypeRepository;
import com.dvx.repositories.TypeSeatRepository;
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
public class TypeSeatRepositoryImpl implements TypeSeatRepository {

    @Autowired
    private LocalSessionFactoryBean Factory;

    @Override
    public List<TypesSeat> getAllTypeSeat() {
        Session session = Factory.getObject().getCurrentSession();
        Query query = session.createNamedQuery("TypesSeat.findAll");
        return query.getResultList();
    }

}
