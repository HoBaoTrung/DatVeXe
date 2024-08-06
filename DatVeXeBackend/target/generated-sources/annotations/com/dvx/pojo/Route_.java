package com.dvx.pojo;

import com.dvx.pojo.Station;
import com.dvx.pojo.Trip;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Station> toStation;
    public static volatile SingularAttribute<Route, Date> createdAt;
    public static volatile SingularAttribute<Route, Double> routePrice;
    public static volatile SingularAttribute<Route, String> name;
    public static volatile SetAttribute<Route, Trip> tripSet;
    public static volatile SingularAttribute<Route, Long> id;
    public static volatile SingularAttribute<Route, Station> fromStation;

}