package entity;

import entity.CartItem;
import entity.Customer;
import entity.ItemOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, String> note;
    public static volatile SingularAttribute<Cart, Customer> customerPersonId;
    public static volatile CollectionAttribute<Cart, CartItem> cartItemCollection;
    public static volatile CollectionAttribute<Cart, ItemOrder> order1Collection;
    public static volatile SingularAttribute<Cart, Float> totalPrice;
    public static volatile SingularAttribute<Cart, Integer> id;

}