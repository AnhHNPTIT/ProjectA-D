package entity;

import entity.Cart;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(ItemOrder.class)
public class ItemOrder_ { 

    public static volatile SingularAttribute<ItemOrder, String> note;
    public static volatile SingularAttribute<ItemOrder, String> orderTime;
    public static volatile SingularAttribute<ItemOrder, Float> shippingFee;
    public static volatile SingularAttribute<ItemOrder, Cart> cartId;
    public static volatile SingularAttribute<ItemOrder, Integer> id;
    public static volatile SingularAttribute<ItemOrder, Date> palcedOn;
    public static volatile SingularAttribute<ItemOrder, String> status;
    public static volatile SingularAttribute<ItemOrder, String> paymentType;

}