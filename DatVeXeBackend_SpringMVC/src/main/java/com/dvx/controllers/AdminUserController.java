/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.User;
import com.dvx.services.RoleService;
import com.dvx.services.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
public class AdminUserController {

    @Autowired
    private UserService useSer;

    @Autowired
    private RoleService roleSer;

    @Autowired
    private Environment env;

    @GetMapping("/user")
    public String index(Model model, @RequestParam Map<String, String> allParams) {

        List<User> list = this.useSer.getAllUser(allParams);

        model.addAttribute("users", list);
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.useSer.countUser(allParams);
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "index";
    }

    @GetMapping("/userDetail/{id}")
    public String userDetail(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("roles", this.roleSer.getAllRole());
        if (id > 0) {
            User u = this.useSer.getUserById(id);
            model.addAttribute("user", u);
        } else {
            model.addAttribute("user", new User());
        }
        return "userDetail";
    }

    @PostMapping("/userDetail/{id}")
    public String updateUser(Model model, @ModelAttribute(value = "user") @Valid User u, @PathVariable(value = "id") long id,
            BindingResult result) {
        if (result.hasErrors()) {
            return "userDetail";
        }
        if (!result.hasErrors()) {

            if (this.useSer.addOrUpdateUser(u)) {
                return "redirect:/admin/userDetail/" + id;

            } else {
                model.addAttribute("user", this.useSer.getUserById(id));
                model.addAttribute("err", "Cập nhật thất bại!");
                return "userDetail";
            }

        }
        return "redirect:/admin/userDetail/" + id;
    }

}
