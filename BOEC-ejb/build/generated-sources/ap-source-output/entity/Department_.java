package entity;

import entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, String> size;
    public static volatile SingularAttribute<Department, String> intro;
    public static volatile SingularAttribute<Department, String> name;
    public static volatile CollectionAttribute<Department, Employee> employeeCollection;
    public static volatile SingularAttribute<Department, String> location;
    public static volatile SingularAttribute<Department, Integer> id;

}