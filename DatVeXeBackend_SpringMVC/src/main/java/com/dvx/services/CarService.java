/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.Car;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface CarService {
    public List<Car> getAllCar();
    public Car getById(long id);
    public boolean addOrUpdateCar(Car c);
    public boolean deleteCar(long id);
}
