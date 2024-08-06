package com.dvx.pojo;

import com.dvx.pojo.Order;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-05T17:08:26")
@StaticMetamodel(OnlinePaymentResult.class)
public class OnlinePaymentResult_ { 

    public static volatile SingularAttribute<OnlinePaymentResult, Date> createdAt;
    public static volatile SingularAttribute<OnlinePaymentResult, String> paymentCode;
    public static volatile SingularAttribute<OnlinePaymentResult, Long> paymentId;
    public static volatile SetAttribute<OnlinePaymentResult, Order> order1Set;

}