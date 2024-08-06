package com.dvx.pojo;

import com.dvx.pojo.OnlinePaymentResult;
import com.dvx.pojo.Ticket;
import com.dvx.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SetAttribute<Order, Ticket> ticketSet;
    public static volatile SingularAttribute<Order, OnlinePaymentResult> paymentId;
    public static volatile SingularAttribute<Order, User> customerId;
    public static volatile SingularAttribute<Order, Long> id;

}