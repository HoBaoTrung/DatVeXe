/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.controllers;

import com.dvx.pojo.Orders;
import com.dvx.pojo.User;
import com.dvx.services.OrderService;
import com.dvx.services.TicketService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    
    @Autowired
    private OrderService orderSer;
    
    @Autowired
    private TicketService ticketService;
    
    @GetMapping("/order")
    public String order(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("orders", orderSer.getAllOrder(params));
        return "order";
    }
    
    @GetMapping("/orderDetail/{id}")
    public String orderDetail(Model model, @PathVariable(value = "id") long id) {
        Orders order = orderSer.getById(id);
        model.addAttribute("tickets", ticketService.getByOrder(order));
        model.addAttribute("order", order);
        return "orderDetail";
    }
    
}
