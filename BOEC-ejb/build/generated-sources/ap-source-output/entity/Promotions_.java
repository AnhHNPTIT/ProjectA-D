package entity;

import entity.Item;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Promotions.class)
public class Promotions_ { 

    public static volatile CollectionAttribute<Promotions, Item> itemCollection;
    public static volatile SingularAttribute<Promotions, Date> fromDiscount;
    public static volatile SingularAttribute<Promotions, String> discount;
    public static volatile SingularAttribute<Promotions, Integer> id;
    public static volatile SingularAttribute<Promotions, Date> endDiscount;
    public static volatile SingularAttribute<Promotions, Float> priceAfterDiscount;

}