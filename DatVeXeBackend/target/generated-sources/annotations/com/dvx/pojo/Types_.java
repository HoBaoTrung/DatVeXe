package com.dvx.pojo;

import com.dvx.pojo.Car;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Types.class)
public class Types_ { 

    public static volatile SingularAttribute<Types, String> image;
    public static volatile SingularAttribute<Types, Integer> quantity;
    public static volatile SetAttribute<Types, Car> carSet;
    public static volatile SingularAttribute<Types, String> name;
    public static volatile SingularAttribute<Types, Long> id;

}