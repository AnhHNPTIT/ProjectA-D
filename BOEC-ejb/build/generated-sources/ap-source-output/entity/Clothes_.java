package entity;

import entity.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Clothes.class)
public class Clothes_ { 

    public static volatile SingularAttribute<Clothes, Integer> itemId;
    public static volatile SingularAttribute<Clothes, Item> item;
    public static volatile SingularAttribute<Clothes, String> material;
    public static volatile SingularAttribute<Clothes, String> brand;
    public static volatile SingularAttribute<Clothes, String> typeOfGender;

}