/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.Car;
import com.dvx.services.CarService;
import com.dvx.services.TypesSeatService;
import com.dvx.services.TypesService;
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
public class AdminCarController {

    @Autowired
    private CarService carSer;

    @Autowired
    private TypesService tySer;

    @Autowired
    private TypesSeatService typeSeat;

    @Autowired
    private Environment env;

    @GetMapping("/vehicle")
    public String list(Model model, @RequestParam Map<String, String> params) {
        System.out.println(carSer.getAllCar());
        model.addAttribute("cars", carSer.getAllCar());
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

//        long count = this.tripSer.countTrip();
//        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "vehicle";
    }

    private String getInit(Model model) {
        model.addAttribute("types", this.tySer.getAllType());
        model.addAttribute("typeSeat", this.typeSeat.getAllTypeSeat());
        return "vehicleDetail";
    }

    @GetMapping("/vehicleDetail")
    public String getAddCar(Model model) {
        model.addAttribute("car", new Car());
        return getInit(model);

    }

    @PostMapping("/vehicleDetail")
    public String addCar(Model model,
            @ModelAttribute(value = "car") @Valid Car car, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            if (car.getFile().isEmpty()) {
                model.addAttribute("errImage", "Phải có hình xe");
            }
           
            return getInit(model);
        }
        if (!this.carSer.addOrUpdateCar(car)) {
            model.addAttribute("err", "Thêm thất bại!");
            model.addAttribute("car", new Car());
            return "vehicleDetail";
        }
        return "redirect:/admin/vehicle";
    }

    @GetMapping("/vehicleDetail/{id}")
    public String vehicleDetail(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("types", this.tySer.getAllType());
        model.addAttribute("car", this.carSer.getById(id));
        model.addAttribute("typeSeat", this.typeSeat.getAllTypeSeat());
        return "vehicleDetail";
    }

    @PostMapping("/vehicleDetail/{id}")
    public String updateCar(Model model, @PathVariable(value = "id") long id,
            @ModelAttribute(value = "car") @Valid Car car, BindingResult bindingResult) {

        if (!this.carSer.addOrUpdateCar(car)) {
            model.addAttribute("err", "Cập nhật thất bại!");
            model.addAttribute("car", this.carSer.getById(id));
            return "vehicleDetail";
        }
        return "redirect:/admin/vehicleDetail/" + id;
    }
}
