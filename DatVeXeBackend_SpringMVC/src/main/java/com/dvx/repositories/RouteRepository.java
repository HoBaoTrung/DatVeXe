/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.repositories;

import com.dvx.pojo.Route;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public interface RouteRepository {
    public Route findRoute(Map<String, String> params);
    public List<Route> getAllRoute(Map<String, String> params);
    public long countRoute(Map<String, String> params);
    public Route findById(Long id);
    public boolean addOrUpdateRoute(Route id);
    boolean deleteRoute(long id);
}
