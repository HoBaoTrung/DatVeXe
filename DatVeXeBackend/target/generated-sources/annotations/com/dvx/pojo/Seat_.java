package com.dvx.pojo;

import com.dvx.pojo.Car;
import com.dvx.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Seat.class)
public class Seat_ { 

    public static volatile SingularAttribute<Seat, String> code;
    public static volatile SetAttribute<Seat, Ticket> ticketSet;
    public static volatile SingularAttribute<Seat, Long> id;
    public static volatile SingularAttribute<Seat, Car> carId;

}