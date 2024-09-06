/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.Route;
import com.dvx.pojo.Trip;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface TripService {

    public List<?> getAllTrip(Map<String, String> params);

    public Long countTrip();

    public Trip getTripbyID(long id);

    public List<Trip> findTripByRoute(Route r, Calendar d);

    public boolean addOrUpdateTrip(Trip p) throws Exception;

    public boolean deleteTrip(long t);
}
