/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Route;
import com.dvx.repositories.RouteRepository;
import com.dvx.repositories.StationRepository;
import com.dvx.services.RouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route findRoute(Map<String, String> params) {
        return this.routeRepository.findRoute(params);
    }

    @Override
    public List<Route> getAllRoute() {
        return this.routeRepository.getAllRoute();
    }

    @Override
    public Route findById(Long id) {
  return this.routeRepository.findById(id);}

}
