package com.dvx.mapper;

import com.dvx.dto.TripDTO;
import com.dvx.pojo.Trip;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("tripDTOMapper")
public class TripDTOMapper implements Function<Trip, TripDTO> {

    @Override
    public TripDTO apply(Trip t) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String time=timeFormat.format(t.getDepartAt());
        
        timeFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date=timeFormat.format(t.getDepartAt());
        return TripDTO.builder()
                .id(t.getId())
                .carImage(t.getCarId().getImage())
                .departureDate(date)
                .departureTime(time)
                .price(t.getPrice() + "")
                .nameCarType(t.getCarId().getTypeId().getName())
                .carNumber(t.getCarId().getCarNumber())
                .build();
    }
    
    public List<TripDTO> toOrdersResponseList(List<Trip> trips){
        List<TripDTO> list = new ArrayList(trips.size());
        Iterator var3 = trips.iterator();

        while(var3.hasNext()) {
            Trip t = (Trip)var3.next();
            list.add(this.apply(t));
        }

        return list;

    }

}
