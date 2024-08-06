package com.dvx.pojo;

import com.dvx.pojo.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Station.class)
public class Station_ { 

    public static volatile SetAttribute<Station, Route> routeSet1;
    public static volatile SingularAttribute<Station, String> name;
    public static volatile SingularAttribute<Station, Long> id;
    public static volatile SetAttribute<Station, Route> routeSet;

}