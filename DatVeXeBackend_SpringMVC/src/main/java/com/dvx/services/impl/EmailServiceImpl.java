/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.repositories.EmailRepository;
import com.dvx.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepo;
    
    @Override
    public void sendEmailForgotPassword(String email, String newPass) {
        emailRepo.sendEmailForgotPassword(email, newPass);
    }
    
}
