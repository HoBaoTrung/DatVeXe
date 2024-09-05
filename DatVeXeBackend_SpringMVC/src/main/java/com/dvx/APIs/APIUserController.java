/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.APIs;

import com.dvx.dto.AuthenticationRequest;
import com.dvx.mapper.ValidationException;
import com.dvx.pojo.User;
import com.dvx.services.AuthenticationService;
import com.dvx.services.JwtService;
import com.dvx.services.RoleService;
import com.dvx.services.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class APIUserController {

    @Autowired
    private UserService userSer;
    
     @Autowired
    private RoleService roleService;

    @Autowired
    private AuthenticationService authenticationService;

    @DeleteMapping("/deleteUser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {

        this.userSer.deleteUser(id);
    }

    @PostMapping("/public/login/")
    @CrossOrigin
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        System.out.println(authenticationRequest);
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("/public/register/")
    public ResponseEntity<?> createUser(@RequestParam Map<String, String> params) {
        User user = new User();
        user.setPhonenumber(params.get("phoneNumber"));
        user.setEmail(params.get("email"));
        user.setPassword(params.get("password"));
        user.setFirstName(params.get("firstName"));
        user.setLastName(params.get("lastName"));
        user.setIsActive(true);
        user.setCreatedAt();
        user.setAddress("null");
        user.setUsername(params.get("firstName")+"_"+params.get("lastName"));
        user.setRoleId(roleService.getRoleByName("USER"));
        user.setAvatar("https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center");
         try {
            userSer.addOrUpdateUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getErrors());
        }
       


    }

}
