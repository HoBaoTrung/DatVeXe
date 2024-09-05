/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dvx.dto.UserDTO;
import com.dvx.mapper.UserDTOMapper;
import com.dvx.mapper.ValidationException;
import com.dvx.pojo.User;
import com.dvx.repositories.UserRepository;
import com.dvx.services.UserService;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.isEmailExist(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = this.userRepository.getUserByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("khong ton tai");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRoleId().getUserRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getEmail(), u.getPassword(), authorities);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUser(Map<String, String> params) {

        return this.userRepository.getAllUser(params);
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public boolean deleteUser(long id) {
        return this.userRepository.deleteUser(id);
    }

    @Override
    public boolean addOrUpdateUser(User user) {
        Map<String, String> errors = validateUser(user);
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        if (user.getFile() != null) {
            if (!user.getFile().isEmpty())
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        return this.userRepository.addOrUpdateUser(user);
    }

    @Override
    public Long countUser(Map<String, String> params) {
        return this.userRepository.countUser(params);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepository.authUser(username, password);
    }

    @Override
    public UserDTO toDTO(User user) {
        return userDTOMapper.apply(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }

    public Map<String, String> validateUser(User user) {
        Map<String, String> errors = new HashMap<>();

        if (userRepository.isEmailExist(user.getEmail())) {
            errors.put("email", "Email already exists");
        }
        if (userRepository.existsByFirstNameAndLastName(user.getFirstName(), user.getLastName())) {
            errors.put("name", "First name and last name combination already exists");
        }
        if (userRepository.isPhoneExist(user.getPhonenumber())) {
            errors.put("phone", "Phone number already exists");
        }

        return errors;
    }

}
