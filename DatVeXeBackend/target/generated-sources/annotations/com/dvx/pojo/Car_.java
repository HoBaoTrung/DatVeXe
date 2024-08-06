package com.dvx.pojo;

import com.dvx.pojo.Seat;
import com.dvx.pojo.Trip;
import com.dvx.pojo.Types;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, String> carNumber;
    public static volatile SetAttribute<Car, Trip> tripSet;
    public static volatile SingularAttribute<Car, Types> typeId;
    public static volatile SingularAttribute<Car, Long> id;
    public static volatile SingularAttribute<Car, Double> seatPrice;
    public static volatile SetAttribute<Car, Seat> seatSet;

}