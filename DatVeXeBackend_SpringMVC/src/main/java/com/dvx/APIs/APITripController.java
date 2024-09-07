/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.APIs;

import com.dvx.dto.TripDTO;
import com.dvx.mapper.TripDTOMapper;
import com.dvx.pojo.Route;
import com.dvx.pojo.Trip;
import com.dvx.services.RouteService;
import com.dvx.services.TripService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class APITripController {

    @Autowired
    private RouteService r;

    @Autowired
    private TripService trip;

    @Autowired
    private TripDTOMapper mapper;

    @Autowired
    private SimpleDateFormat f;

    @PostMapping(path = "/public/trip/")
    @CrossOrigin
    public ResponseEntity<List<?>> list(
            @RequestParam Map<String, String> params) throws ParseException {

        return new ResponseEntity<>(trip.getAllTrip(params), HttpStatus.OK);

    }

    //hiển thị thông tin chi tiết chuyến xe
    @GetMapping("/public/tripDetail/{id}")
    @CrossOrigin
    public ResponseEntity<?> tripDetail(
            @PathVariable(value = "id") long tripid) throws ParseException {
        List<Object> res = new ArrayList<>();
        Trip t = trip.getTripbyID(tripid);
        TripDTO tripdto = mapper.apply(t);
        res.add(tripdto);
        //Các ghế đã có người mua của chuyến đi
        res.add(trip.getTicketsBought(t));
       
        return new ResponseEntity<>(res, HttpStatus.OK);

    }
    
    

    @DeleteMapping("/deleteTrip/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {

        this.trip.deleteTrip(id);
    }

}
