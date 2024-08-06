package com.dvx.pojo;

import com.dvx.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Otp.class)
public class Otp_ { 

    public static volatile SingularAttribute<Otp, String> code;
    public static volatile SingularAttribute<Otp, Long> id;
    public static volatile SingularAttribute<Otp, User> userID;

}