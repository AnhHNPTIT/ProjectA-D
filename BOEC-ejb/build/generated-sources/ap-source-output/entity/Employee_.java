package entity;

import entity.Account;
import entity.Bill;
import entity.Department;
import entity.Person;
import entity.Rank;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Account> accountId;
    public static volatile SingularAttribute<Employee, Rank> rankId;
    public static volatile SingularAttribute<Employee, Person> person;
    public static volatile SingularAttribute<Employee, Department> departmentId;
    public static volatile SingularAttribute<Employee, Integer> personId;
    public static volatile SingularAttribute<Employee, String> position;
    public static volatile SingularAttribute<Employee, Float> salary;
    public static volatile CollectionAttribute<Employee, Bill> billCollection;

}