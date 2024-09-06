/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.pojo.Route;
import com.dvx.pojo.Station;
import com.dvx.pojo.User;
import com.dvx.repositories.EmailRepository;
import com.dvx.repositories.RouteRepository;
import com.dvx.services.UserService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class EmailRepositoryImpl implements EmailRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private Environment env;
    
    @Autowired
    private UserService userSer;

    @Autowired
    private JavaMailSender mailSender;

   

    private void sendMail(String mail, String Subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("trungh7430@gmail.com");
        message.setTo(mail);
        message.setSubject(Subject);
        message.setText(content);

        mailSender.send(message);
        System.out.println("22132111");
    }

    @Override
    public void sendEmailForgotPassword(String email, String newPass) {
        
        String content = "Your new password: " + newPass;
        sendMail(email, "Update your password", content);
        
    }

}
