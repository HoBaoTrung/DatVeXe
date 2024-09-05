package com.dvx.services.impl;

import com.dvx.dto.*;
import com.dvx.pojo.Role;
import com.dvx.pojo.User;
import com.dvx.repositories.RoleRepository;
import com.dvx.repositories.UserRepository;
import com.dvx.services.AuthenticationService;
import com.dvx.services.JwtService;
import com.dvx.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import org.passay.*;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

//    @Autowired
//    private EmailService emailService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {

        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        
        return AuthenticationResponse.builder()
                .accessToken(jwtService.generateToken(userDetails))
                .userDetails(userDetailsService.toDTO(userDetailsService.getUserByEmail(userDetails.getUsername())))
                .build();
    }

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = (User) userDetailsService.loadUserByUsername(registerRequest.getEmail());
        if (user != null) {
            throw new IllegalArgumentException("User name  is exist");
        } else {
            if (userDetailsService.isEmailExist(registerRequest.getEmail())) {
                throw new IllegalArgumentException("Email is exist");
            }
        }
        if (user.getEmail().equals(registerRequest.getEmail())) {
            throw new IllegalArgumentException("Email is exist");
        }
        Role role = roleRepository.getRoleByName(registerRequest.getRole());
        if (role == null) {
            throw new IllegalArgumentException("Role field is invalid");
        }
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setRoleId(role);
        newUser.setIsActive(true);
        newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        userDetailsService.addOrUpdateUser(newUser);
        return AuthenticationResponse.builder()
                .accessToken(jwtService.generateToken((UserDetails) newUser))
                .userDetails(userDetailsService.toDTO(newUser))
                .build();
    }

//    @Override
//    public AuthenticationResponse loginWithGoogle(LoginWithGoogleRequest data) {
//        User user = userDetailsService.getUserByEmail(data.getEmail());
//        if (user == null) {
//            Role role = roleRepository.getRoleByName("USER");
//            String password = passwordEncoder.encode(generatePassword());
//            user = User.builder()
//                    .username(data.getUsername())
//                    .email(data.getEmail())
//                    .firstname(data.getFirstName())
//                    .username(data.getEmail())
//                    .lastname(data.getLastName())
//                    .avatar(data.getAvatar())
//                    .role(role)
//                    .isActive(true)
//                    .password(password)
//                    .build();
//            userRepository.saveUser(user);
//            emailService.sendEmail(
//                    user.getEmail(),
//                    "??ng k� t�i kho?n t?i Bus Station",
//                    String.format("M?t kh?u t�i kho?n c?a b?n l� %s", password));
//        }
//
//        String accessToken = jwtService.generateToken(user);
//        UserDTO userDTO = userDetailsService.toDTO(user);
//        return AuthenticationResponse.builder()
//                .accessToken(accessToken)
//                .userDetails(userDTO)
//                .build();
//    }
    private String generatePassword() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return "-1";
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(10, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }
}
