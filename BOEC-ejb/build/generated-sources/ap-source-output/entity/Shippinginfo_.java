package entity;

import entity.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Shippinginfo.class)
public class Shippinginfo_ { 

    public static volatile SingularAttribute<Shippinginfo, Item> itemId;
    public static volatile SingularAttribute<Shippinginfo, Float> fee;
    public static volatile SingularAttribute<Shippinginfo, Float> weight;
    public static volatile SingularAttribute<Shippinginfo, Integer> id;
    public static volatile SingularAttribute<Shippinginfo, Float> parceSize;

}