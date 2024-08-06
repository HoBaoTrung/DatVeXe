package com.dvx.pojo;

import com.dvx.pojo.Order;
import com.dvx.pojo.Seat;
import com.dvx.pojo.Trip;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Date> createdAt;
    public static volatile SingularAttribute<Ticket, Order> orderId;
    public static volatile SingularAttribute<Ticket, Date> paidAt;
    public static volatile SingularAttribute<Ticket, Seat> seatId;
    public static volatile SingularAttribute<Ticket, Trip> tripId;
    public static volatile SingularAttribute<Ticket, Long> id;
    public static volatile SingularAttribute<Ticket, Boolean> isActive;

}