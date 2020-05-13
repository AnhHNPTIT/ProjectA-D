package entity;

import entity.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Creditcard.class)
public class Creditcard_ { 

    public static volatile SingularAttribute<Creditcard, Integer> customerPersonId;
    public static volatile SingularAttribute<Creditcard, Integer> customerId;
    public static volatile SingularAttribute<Creditcard, Date> expireDate;
    public static volatile SingularAttribute<Creditcard, Integer> id;
    public static volatile SingularAttribute<Creditcard, String> type;
    public static volatile SingularAttribute<Creditcard, Customer> customerPersonId2;
    public static volatile SingularAttribute<Creditcard, String> cardNumber;

}