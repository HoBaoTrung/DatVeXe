/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.User;
import com.dvx.services.StationService;
import com.dvx.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private StationService statioService;

    @GetMapping("/")
    public String index(Model model, Principal p) {

        model.addAttribute("mes", "Trung");
        return "index";
    }

    @GetMapping("/userDetail")
    public String userDetail(Model model) {

        return "userDetail";
    }

    @GetMapping("/vehicle")
    public String vehicle(Model model) {

        return "vehicle";
    }

    @GetMapping("/vehicleDetail")
    public String vehicleDetail(Model model) {

        return "vehicleDetail";
    }

    @GetMapping("/types")
    public String types(Model model) {

        return "types";
    }

    @GetMapping("/typeDetail")
    public String typeDetail(Model model) {

        return "typeDetail";
    }

    @GetMapping("/route")
    public String route(Model model) {

        return "route";
    }
    @GetMapping("/routeDetail")
    public String routeDetail(Model model) {
        model.addAttribute("stations", this.statioService.getStations());
        return "routeDetail";
    }
    
  
    
    @GetMapping("/order")
    public String order(Model model) {

        return "order";
    }
    @GetMapping("/orderDetail")
    public String orderDetail(Model model) {

        return "orderDetail";
    }

    @GetMapping("/stats")
    public String stats(Model model) {

        return "stats";
    }
}
