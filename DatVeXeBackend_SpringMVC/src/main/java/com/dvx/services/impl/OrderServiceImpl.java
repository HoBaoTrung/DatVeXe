/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Orders;
import com.dvx.pojo.User;
import com.dvx.repositories.OrderRepository;
import com.dvx.services.OrderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public List<Orders> getByUser(User id){
        return this.orderRepository.getByUser(id);
    }

    @Override
    public List<Orders> getAllOrder(Map<String, String> params) {
        return this.orderRepository.getAllOrder(params);
    }

    @Override
    public int countOrder(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Orders getById(long id) {
        return this.orderRepository.getById(id);
    }

    @Override
    public boolean deleteOrder(long id) {
        return this.orderRepository.deleteOrder(id);
    }

    @Override
    public boolean addOrUpdateOrder(Orders u) {
        return this.orderRepository.addOrUpdateOrder(u);
    }

}
