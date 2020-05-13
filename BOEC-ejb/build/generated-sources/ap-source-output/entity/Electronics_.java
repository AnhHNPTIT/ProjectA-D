package entity;

import entity.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Electronics.class)
public class Electronics_ { 

    public static volatile SingularAttribute<Electronics, Integer> itemId;
    public static volatile SingularAttribute<Electronics, Item> item;
    public static volatile SingularAttribute<Electronics, String> color;
    public static volatile SingularAttribute<Electronics, String> size;
    public static volatile SingularAttribute<Electronics, String> technology;
    public static volatile SingularAttribute<Electronics, String> power;
    public static volatile SingularAttribute<Electronics, String> type;

}