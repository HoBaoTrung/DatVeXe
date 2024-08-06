package com.dvx.pojo;

import com.dvx.pojo.Order;
import com.dvx.pojo.Otp;
import com.dvx.pojo.Role;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, Role> roleId;
    public static volatile SetAttribute<User, Order> order1Set;
    public static volatile SingularAttribute<User, String> phonenumber;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Boolean> isActive;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, Date> createdAt;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Otp> otpSet;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}