/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Car;
import com.dvx.pojo.Route;
import com.dvx.pojo.Station;
import com.dvx.pojo.Trip;
import com.dvx.repositories.CarRepository;
import com.dvx.repositories.RouteRepository;
import com.dvx.repositories.StationRepository;
import com.dvx.repositories.TripRepository;
import com.dvx.services.StationService;
import com.dvx.services.TripService;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TripServiceImpl implements TripService {
    
    @Autowired
    private CarRepository carRepo;
    
    @Autowired
    private TripRepository trip;
    
    @Autowired
    private RouteRepository routeRepo;
    
    @Override
    public List<Trip> findTripByRoute(Route r, Calendar d) {
        
        return this.trip.findTripByRoute(r, d);
    }
    
    @Override
    public List<Trip> getAllTrip(Map<String, String> params) {
        return this.trip.getAllTrip(params);
    }
    
    
    
    @Override
    public Trip getTripbyID(long id) {
        return this.trip.getTripbyID(id);
    }
    
    @Override
    public boolean addOrUpdateTrip(Trip t) throws Exception{
        Route r =this.routeRepo.findById(t.getRouteId().getId());
        Car c = this.carRepo.getById(t.getCarId().getId());
        
        t.setPrice(r.getRoutePrice() + c.getSeatPrice());
        
        // Tạo DateTimeFormatter với định dạng tương ứng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Phân tích chuỗi thành LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(t.getDatetime(), formatter);

        // Chọn múi giờ (zone ID) - ví dụ: múi giờ hệ thống
        ZoneId zoneId = ZoneId.systemDefault(); // Hoặc chọn một zone ID cụ thể

        // Chuyển LocalDateTime sang ZonedDateTime
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        // Chuyển ZonedDateTime sang Instant
        Instant instant = zonedDateTime.toInstant();

        // Chuyển Instant sang Date
        Date date = Date.from(instant);

        t.setIsActive(true);
        t.setDepartAt(date);
        
        localDateTime = LocalDateTime.now();
        zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        t.setCreatedAt(Date.from(zonedDateTime.toInstant()));
        
        long time1 = t.getCreatedAt().getTime();
        long time2= t.getDepartAt().getTime();
        long diffInMillis = Math.abs(time2 - time1);
        
//        if( TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS)<=3){
//            throw new Exception("Thời gian đi phải từ 3 ngày sau!");
//        }
        
        return this.trip.addOrUpdateTrip(t);
    }

    @Override
    public Long countTrip() {
   return this.trip.countTrip();  }
    
}
