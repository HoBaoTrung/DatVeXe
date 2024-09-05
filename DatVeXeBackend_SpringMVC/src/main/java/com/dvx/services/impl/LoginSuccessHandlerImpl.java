/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

//import com.dvx.services.LoginSuccessHandler;
import com.dvx.pojo.User;
import com.dvx.repositories.UserRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class LoginSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest hsr,
            HttpServletResponse response, Authentication a)
            throws IOException, ServletException {
        System.out.println(a.getName());
        User u = userRepository.getUserByEmail(a.getName());
        if (u.getRoleId().getUserRole().equalsIgnoreCase("admin")) 
            response.sendRedirect("/DatVeXeBackend/admin/user");
      
        
       
    }
}
