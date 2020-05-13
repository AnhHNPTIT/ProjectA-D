package entity;

import entity.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile CollectionAttribute<Notification, Customer> customerCollection;
    public static volatile SingularAttribute<Notification, Integer> id;
    public static volatile SingularAttribute<Notification, Date> time;
    public static volatile SingularAttribute<Notification, String> content;

}