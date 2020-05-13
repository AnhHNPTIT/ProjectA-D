package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Voucher.class)
public class Voucher_ { 

    public static volatile SingularAttribute<Voucher, Integer> quantity;
    public static volatile CollectionAttribute<Voucher, Customer> customerCollection;
    public static volatile SingularAttribute<Voucher, Long> limitedValue;
    public static volatile SingularAttribute<Voucher, Integer> id;
    public static volatile SingularAttribute<Voucher, Integer> couponValue;

}