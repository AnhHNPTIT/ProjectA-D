package entity;

import entity.Address;
import entity.Customer;
import entity.Employee;
import entity.Fullname;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> imageURI;
    public static volatile SingularAttribute<Person, String> phoneNumber;
    public static volatile SingularAttribute<Person, String> gender;
    public static volatile SingularAttribute<Person, String> identifyNumber;
    public static volatile SingularAttribute<Person, Date> dob;
    public static volatile SingularAttribute<Person, Fullname> fullNameId;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, Employee> employee;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, Address> addressId;
    public static volatile SingularAttribute<Person, Customer> customer;

}