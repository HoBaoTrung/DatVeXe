/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ASUS
 */
public interface UserService  extends UserDetailsService{
     public User getUserByUsername(String username);
}
