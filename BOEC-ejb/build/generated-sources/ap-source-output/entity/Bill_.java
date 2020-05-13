package entity;

import entity.Employee;
import entity.ItemOrder;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Date> date;
    public static volatile SingularAttribute<Bill, String> note;
    public static volatile SingularAttribute<Bill, Employee> employeePersonId2;
    public static volatile SingularAttribute<Bill, ItemOrder> orderId;
    public static volatile SingularAttribute<Bill, Integer> orderShipCompanyCompanyId;
    public static volatile SingularAttribute<Bill, Integer> employeePersonId;
    public static volatile SingularAttribute<Bill, Integer> employeeId;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Float> sumary;

}