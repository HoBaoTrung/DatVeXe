/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.Types;
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
public class AdminTypesController {

    @Autowired
    private TypesService typeSer;

    @Autowired
    private Environment env;

    @GetMapping("/types")
    public String types(Model model, @RequestParam Map<String, String> params) {
        System.out.println(typeSer.getAllType());
        model.addAttribute("types", typeSer.getAllType());
        return "types";
    }


    @GetMapping("/typeDetail")
    public String getAddType(Model model) {
        
        model.addAttribute("type", new Types());
        return "typeDetail";
    }
    
    @PostMapping("/typeDetail")
    public String postAddType(Model model, @ModelAttribute(value = "type") @Valid Types t) {
        
        if (!this.typeSer.addOrUpdate(t)) {
            model.addAttribute("err", "Thêm thất bại!");
            model.addAttribute("type", new Types());
            return "typeDetail";
        }
        return "redirect:/admin/types";
    }
    
    @GetMapping("/typeDetail/{id}")
    public String typeDetail(Model model, @PathVariable(value = "id") long id) {
        
        model.addAttribute("type", this.typeSer.getTypeById(id));
        return "typeDetail";
    }
    @PostMapping("/typeDetail/{id}")
    public String postUpdateType(Model model, @ModelAttribute(value = "type") @Valid Types t,@PathVariable(value = "id") long id) {
        
        if (!this.typeSer.addOrUpdate(t)) {
            model.addAttribute("err", "Thêm thất bại!");
            model.addAttribute("type", this.typeSer.getTypeById(id));
            return "typeDetail";
        }
        return "redirect:/admin/typeDetail/"+id;
    }
}
