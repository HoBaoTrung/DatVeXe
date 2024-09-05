/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.dto.UserDTO;
import com.dvx.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ASUS
 */
public interface UserService extends UserDetailsService {

    public boolean isEmailExist(String email);

    public User getUserByUsername(String username);

    public boolean deleteUser(long id);

    public List<User> getAllUser(Map<String, String> params);

    public User getUserByEmail(String email);

    public Long countUser(Map<String, String> params);

    UserDTO toDTO(User user);

    public boolean addOrUpdateUser(User user);

    boolean authUser(String username, String password);
    
    public User getUserById(long id);
}
