/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.User;
import com.dvx.services.StationService;
import com.dvx.services.StatsService;
import com.dvx.services.UserService;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class StatsController {

    @Autowired
    private StatsService statsService;


    @GetMapping("/stats")
    public String stats(Model model, @RequestParam Map<String, String> params) {
        String period = params.getOrDefault("period", "QUARTER");
       
        String year = params.getOrDefault("year", String.valueOf(LocalDate.now().getYear()));
        
        model.addAttribute("statsRevenueByPeroid", 
                this.statsService.statsRevenueByPeriod(Integer.parseInt(year), period));
       
        
        return "stats";
    }
}
