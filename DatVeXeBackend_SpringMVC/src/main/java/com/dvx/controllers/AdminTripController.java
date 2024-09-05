/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.Trip;
import com.dvx.services.CarService;
import com.dvx.services.RouteService;
import com.dvx.services.TripService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:configs.properties")
public class AdminTripController {

    @Autowired
    private TripService tripSer;

    @Autowired
    private RouteService routeSer;

    @Autowired
    private CarService carSer;

    @Autowired
    private Environment env;

    @GetMapping("/trip")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("trips", tripSer.getAllTrip(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.tripSer.countTrip();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "trip";
    }

    @GetMapping("/tripDetail/{id}")
    public String tripDetail(Model model, @PathVariable(value = "id") long id, @RequestParam Map<String, String> params) {

        model.addAttribute("routes", this.routeSer.getAllRoute(params));
        model.addAttribute("cars", this.carSer.getAllCar());
        Trip t = tripSer.getTripbyID(id);
        t.setDatetime(t.getDepartAt() + "");
        model.addAttribute("trip", t);

        return "tripDetail";
    }

    @GetMapping("/tripDetail")
    public String addTrip(Model model,  @RequestParam Map<String, String> params) {

        model.addAttribute("routes", this.routeSer.getAllRoute(params));
        model.addAttribute("cars", this.carSer.getAllCar());
        
        model.addAttribute("trip", new Trip());

        return "tripDetail";
    }
    
    @PostMapping("/tripDetail")
    public String addTripToDB(Model model, @ModelAttribute(value = "trip") @Valid Trip t,
            BindingResult result) throws ParseException, Exception {

        if (this.tripSer.addOrUpdateTrip(t) == true) {
            return "redirect:/admin/trip";
        }
        return "redirect:/admin/tripDetail";
    }

    

}
