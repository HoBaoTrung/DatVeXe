/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.repositories;

import com.dvx.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface UserRepository {
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    public boolean isEmailExist(String email);
    User getUserById(long id);
    boolean deleteUser(long id);
    boolean addOrUpdateUser(User u);
    List<User> getAllUser(Map<String,String> params);
    public Long countUser(Map<String, String> params) ;
    boolean authUser(String username, String password);
    public boolean isPhoneExist(String phone);
    boolean existsByFirstNameAndLastName(String firstname, String lastname);
    
}
