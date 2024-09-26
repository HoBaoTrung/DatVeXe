/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dvx.pojo.Car;
import com.dvx.repositories.CarRepository;
import com.dvx.services.CarService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CarRepository carRepo;

    @Override
    public List<Car> getAllCar() {
        return this.carRepo.getAllCar();
    }

    @Override
    public Car getById(long id) {
        return this.carRepo.getById(id);
    }

    @Override
    public boolean addOrUpdateCar(Car c) {
        if (!c.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(c.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                c.setImage(res.get("secure_url").toString());

            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return this.carRepo.addOrUpdateCar(c);
    }

    @Override
    public boolean deleteCar(long id) {
        return this.carRepo.deleteCar(id);
    }


}
