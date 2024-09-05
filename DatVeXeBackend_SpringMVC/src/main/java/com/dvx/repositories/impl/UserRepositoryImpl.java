/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Role;
import com.dvx.pojo.User;
import com.dvx.repositories.UserRepository;
import com.dvx.services.RoleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private RoleService roleSer;

    @Autowired
    private Environment env;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }

    @Override
    public List<User> getAllUser(Map<String, String> params) {

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> rootUser = query.from(User.class);
        Query q = null;

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        List<Predicate> predicates = new ArrayList<>();
        String role = params.get("role");

        if (role == null || role.isEmpty() || role.equalsIgnoreCase("customer")) {
            Role r = roleSer.getRoleByName("USER");

            predicates.add(builder.equal(rootUser.get("roleId"), r));
        } else {
            Role r = roleSer.getRoleByName("STAFF");
            predicates.add(builder.equal(rootUser.get("roleId"), r));
        }

        query.where(predicates.toArray(new Predicate[0]));
        query.orderBy(builder.desc(rootUser.get("id")));

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
    public Long countUser(Map<String, String> params) {

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<User> rootUser = query.from(User.class);
        Query q = null;

        List<Predicate> predicates = new ArrayList<>();
        String role = params.get("role");

        if (role == null || role.isEmpty() || role.equalsIgnoreCase("customer")) {
            Role r = roleSer.getRoleByName("USER");

            predicates.add(builder.equal(rootUser.get("roleId"), r));
        } else {
            Role r = roleSer.getRoleByName("STAFF");
            predicates.add(builder.equal(rootUser.get("roleId"), r));
        }

        query.select(builder.count(rootUser)).where(builder.and(predicates.toArray(new Predicate[0])));

        q = s.createQuery(query);

        return (Long) q.getSingleResult();
    }

    @Override
    public User getUserById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findById");
        q.setParameter("id", id);
        return (User) q.getSingleResult();
    }

    @Override
    public boolean deleteUser(long id) {
        Session s = factory.getObject().getCurrentSession();
        try {
            s.delete(this.getUserById(id));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addOrUpdateUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {

            if (user.getId() == null) {

                s.save(user);

            } else {
                s.update(user);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        System.out.println("1a23s1d231");
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public User getUserByEmail(String email) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByEmail");
        q.setParameter("email", email);
        return (User) q.getSingleResult();
    }

    @Override
    public boolean isEmailExist(String email) {
        Session session = factory.getObject().getCurrentSession();
        Query query = session.createQuery("from User u where u.email = :email", User.class)
                .setParameter("email", email);
        return query.getResultList().size() > 0;
    }

    @Override
    public boolean isPhoneExist(String phone) {
        Session session = factory.getObject().getCurrentSession();
        Query query = session.createQuery("from User u where u.phonenumber = :phonenumber", User.class)
                .setParameter("phonenumber", phone);
        return query.getResultList().size() > 0;
    }

    @Override
    public boolean existsByFirstNameAndLastName(String firstname, String lastname) {
        Session session = factory.getObject().getCurrentSession();
        Query query = session.createQuery("from User u where u.lastName = :lastName and u.firstName = :firstName", User.class)
                .setParameter("lastName", lastname)
                .setParameter("firstName", firstname);
        return query.getResultList().size() > 0;
    }

}
