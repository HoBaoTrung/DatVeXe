package com.dvx.mapper;

import com.dvx.dto.OrderDTO;
import com.dvx.dto.TripDTO;
import com.dvx.pojo.Orders;
import com.dvx.pojo.Ticket;
import com.dvx.pojo.Trip;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("orderDTOMapper")
public class OrderDTOMapper implements Function<Orders, OrderDTO> {

    @Override
    public OrderDTO apply(Orders o) {
        int numerTicket= o.getTicketSet().size();
        List<Ticket> list = new ArrayList<>(o.getTicketSet());
        double priceTrip = list.get(0).getTripId().getPrice();
        
        return OrderDTO.builder()
                .id(o.getId())
                .ticketQuantity(numerTicket)
                .price(numerTicket*priceTrip + "")
                .build();
    }
    
    public List<OrderDTO> toOrdersResponseList(List<Orders> order){
        List<OrderDTO> list = new ArrayList(order.size());
        Iterator var3 = order.iterator();

        while(var3.hasNext()) {
            Orders t = (Orders)var3.next();
            list.add(this.apply(t));
        }

        return list;

    }

}
