package com.dvx.controllers;

import com.dvx.pojo.Car;
import com.dvx.services.CarService;
import com.dvx.services.TypesSeatService;
import com.dvx.services.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@PropertySource("classpath:configs.properties")
public class AdminCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private TypesService typesService;

    @Autowired
    private TypesSeatService typesSeatService;

    @Autowired
    private Environment env;

    @GetMapping("/vehicle")
    public String list(Model model) {
        model.addAttribute("cars", carService.getAllCar());
        return "vehicle";
    }

    @GetMapping("/vehicleDetail")
    public String getAddCar(Model model) {
        return initializeModel(model, new Car());
    }

    @PostMapping("/vehicleDetail")
    public String addCar(Model model, @ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        return processCar(model, car, bindingResult, false);
    }

    @GetMapping("/vehicleDetail/{id}")
    public String vehicleDetail(Model model, @PathVariable long id) {
        model.addAttribute("car", carService.getById(id));
        return initializeModel(model, carService.getById(id));
    }

    @PostMapping("/vehicleDetail/{id}")
    public String updateCar(Model model, @PathVariable long id, @ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        return processCar(model, car, bindingResult, true);
    }

    private String initializeModel(Model model, Car car) {
        model.addAttribute("car", car);
        model.addAttribute("types", typesService.getAllType());
        model.addAttribute("typeSeat", typesSeatService.getAllTypeSeat());
        return "vehicleDetail";
    }

    private String processCar(Model model, Car car, BindingResult bindingResult, boolean isUpdate) {
        if (!isUpdate) {
            if (car.getFile().isEmpty()) {
                model.addAttribute("errImage", "Phải có hình xe");
                return initializeModel(model, car);
            }
        }

        if (bindingResult.hasErrors()) {
            return initializeModel(model, car);
        }

        boolean isSuccess = carService.addOrUpdateCar(car);
        model.addAttribute("err", isSuccess ? null : (isUpdate ? "Cập nhật thất bại!" : "Thêm thất bại!"));
        return isSuccess ? (isUpdate ? "redirect:/admin/vehicleDetail/" + car.getId() : "redirect:/admin/vehicle") : initializeModel(model, car);
    }
}
