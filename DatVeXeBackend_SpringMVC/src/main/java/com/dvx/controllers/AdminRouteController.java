/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.Route;
import com.dvx.services.RouteService;
import com.dvx.services.StationService;
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
public class AdminRouteController {

    @Autowired
    private RouteService routeSer;

    @Autowired
    private StationService stationSer;

    @Autowired
    private Environment env;

    @GetMapping("/route")
    public String route(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("routes", this.routeSer.getAllRoute(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.routeSer.countRoute(params);
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "route";
    }

    @GetMapping("/routeDetail/{id}")
    public String routeDetail(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("route", this.routeSer.findById(id));
        model.addAttribute("stations", this.stationSer.getStations());
        return "routeDetail";
    }

    @PostMapping("/routeDetail/{id}")
    public String updateRouteDetail(Model model, @ModelAttribute(value = "route") @Valid Route route,
            @PathVariable(value = "id") long id, BindingResult result) {
        Route r = this.routeSer.findById(route.getId());
        route.setCreatedAt(r.getCreatedAt());
        if (!result.hasErrors()) {
            if (!this.routeSer.addOrUpdateRoute(route)) {
                model.addAttribute("err", "Cập nhật thất bại!");
                model.addAttribute("route", this.routeSer.findById(id));
                return "routeDetail";
            }
        }
        return "redirect:/admin/routeDetail/" + id;
    }

    @GetMapping("/routeDetail")
    public String getAddDetail(Model model
    ) {
        model.addAttribute("route", new Route());
        model.addAttribute("stations", this.stationSer.getStations());
        return "routeDetail";
    }

    @PostMapping("/routeDetail")
    public String addRoute(Model model, @ModelAttribute(value = "route") @Valid Route route,
            BindingResult result
    ) {
        route.setCreatedAt(null);
        if (result.hasErrors()) {
          
            model.addAttribute("route", new Route());
            model.addAttribute("stations", this.stationSer.getStations());
            return "routeDetail";
        }
        if (!this.routeSer.addOrUpdateRoute(route)) {
            model.addAttribute("err", "Cập nhật thất bại!");
            model.addAttribute("route", new Route());
            return "routeDetail";
        }
        System.out.println(route);
        return "redirect:/admin/route";
    }

}
