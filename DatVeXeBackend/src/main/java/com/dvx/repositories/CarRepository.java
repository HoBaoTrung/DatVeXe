/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.repositories;

import com.dvx.pojo.Car;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public interface CarRepository {
    public Car getById(long id);
    public List<Car> getAllCar();
}
