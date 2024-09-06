/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.repositories.*;
import com.dvx.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface EmailService {
   void sendEmailForgotPassword(String email, String newPass);
    
}
