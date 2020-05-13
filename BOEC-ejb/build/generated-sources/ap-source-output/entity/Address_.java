package entity;

import entity.Company;
import entity.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> number;
    public static volatile SingularAttribute<Address, String> country;
    public static volatile CollectionAttribute<Address, Company> companyCollection;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> district;
    public static volatile CollectionAttribute<Address, Person> personCollection;
    public static volatile SingularAttribute<Address, Integer> id;

}