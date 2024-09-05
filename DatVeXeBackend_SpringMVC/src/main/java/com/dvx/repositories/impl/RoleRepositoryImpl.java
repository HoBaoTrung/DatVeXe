/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Role;
import com.dvx.pojo.Station;
import com.dvx.repositories.RoleRepository;
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
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public Role getRoleByName(String name) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Role.findByUserRole");
        q.setParameter("userRole", name);
        return (Role) q.getSingleResult();
    }

    @Override
    public List<Role> getAllRole() {Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Role.findAll");
        return q.getResultList();
    }

}
