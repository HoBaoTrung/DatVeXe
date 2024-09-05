/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Car;
import com.dvx.pojo.Role;
import com.dvx.pojo.Station;
import com.dvx.repositories.CarRepository;
import com.dvx.repositories.RoleRepository;
import com.dvx.repositories.StationRepository;
import com.dvx.services.CarService;
import com.dvx.services.RoleService;
import com.dvx.services.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public Role getRoleByName(String name) {
        return roleRepo.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRole() {
   return this.roleRepo.getAllRole(); }

}
