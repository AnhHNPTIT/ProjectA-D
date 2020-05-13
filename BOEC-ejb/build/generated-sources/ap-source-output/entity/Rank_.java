package entity;

import entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Rank.class)
public class Rank_ { 

    public static volatile SingularAttribute<Rank, String> note;
    public static volatile SingularAttribute<Rank, String> rankName;
    public static volatile CollectionAttribute<Rank, Employee> employeeCollection;
    public static volatile SingularAttribute<Rank, Integer> id;

}