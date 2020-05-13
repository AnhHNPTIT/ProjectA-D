package entity;

import entity.Account;
import entity.Cart;
import entity.Creditcard;
import entity.Notification;
import entity.Person;
import entity.Voucher;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile CollectionAttribute<Customer, Cart> cartCollection;
    public static volatile CollectionAttribute<Customer, Notification> notificationCollection;
    public static volatile SingularAttribute<Customer, Account> accountId;
    public static volatile CollectionAttribute<Customer, Voucher> voucherCollection;
    public static volatile CollectionAttribute<Customer, Creditcard> creditcardCollection;
    public static volatile SingularAttribute<Customer, Person> person;
    public static volatile SingularAttribute<Customer, String> intro;
    public static volatile SingularAttribute<Customer, Integer> personId;
    public static volatile SingularAttribute<Customer, String> type;

}