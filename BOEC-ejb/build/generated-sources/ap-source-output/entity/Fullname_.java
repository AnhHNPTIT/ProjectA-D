package entity;

import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Fullname.class)
public class Fullname_ { 

    public static volatile SingularAttribute<Fullname, String> firstName;
    public static volatile SingularAttribute<Fullname, String> lastName;
    public static volatile CollectionAttribute<Fullname, Person> personCollection;
    public static volatile SingularAttribute<Fullname, Integer> id;

}