package entity;

import entity.Address;
import entity.Item;
import entity.Shipcompany;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Company.class)
public class Company_ { 

    public static volatile SingularAttribute<Company, Date> establishYear;
    public static volatile SingularAttribute<Company, String> phoneNumber;
    public static volatile CollectionAttribute<Company, Item> itemCollection;
    public static volatile SingularAttribute<Company, String> intro;
    public static volatile SingularAttribute<Company, String> name;
    public static volatile SingularAttribute<Company, Integer> id;
    public static volatile SingularAttribute<Company, String> email;
    public static volatile SingularAttribute<Company, Shipcompany> shipcompany;
    public static volatile SingularAttribute<Company, Address> addressId;

}