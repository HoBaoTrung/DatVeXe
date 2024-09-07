/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.Orders;
import com.dvx.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface OrderService {
    public Orders getById(long id);
    public int countOrder(Map<String, String> params);
    public List<Orders> getAllOrder(Map<String, String> params);
    boolean deleteOrder(long id);
    boolean addOrUpdateOrder(Orders u);
    public List<Orders> getByUser(User id);
}
