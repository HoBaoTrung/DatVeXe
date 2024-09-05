/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.APIs;

import com.dvx.pojo.Route;
import com.dvx.pojo.Trip;
import com.dvx.services.RouteService;
import com.dvx.services.TripService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class APIStripController {

    @Autowired
    private RouteService r;

    @Autowired
    private TripService trip;

    @Autowired
    private SimpleDateFormat f;

    @GetMapping(path = "/trip/")
    @CrossOrigin
    public ResponseEntity<List<Trip>> list(
            @RequestParam Map<String, String> params) throws ParseException {
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(f.parse(params.get("date")));
         
        Route route = this.r.findRoute(params);
        List<Trip>  result = this.trip.findTripByRoute(route, calendar);
       
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteTrip/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {
       
        this.trip.deleteTrip(id);
    }

}
