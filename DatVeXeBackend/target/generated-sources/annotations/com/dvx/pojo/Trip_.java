package com.dvx.pojo;

import com.dvx.pojo.Car;
import com.dvx.pojo.Route;
import com.dvx.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Date> createdAt;
    public static volatile SingularAttribute<Trip, Date> departAt;
    public static volatile SingularAttribute<Trip, Route> routeId;
    public static volatile SetAttribute<Trip, Ticket> ticketSet;
    public static volatile SingularAttribute<Trip, Double> price;
    public static volatile SingularAttribute<Trip, Long> id;
    public static volatile SingularAttribute<Trip, Boolean> isActive;
    public static volatile SingularAttribute<Trip, Car> carId;

}