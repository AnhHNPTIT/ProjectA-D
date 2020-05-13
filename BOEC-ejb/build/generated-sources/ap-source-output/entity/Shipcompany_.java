package entity;

import entity.Company;
import entity.ItemOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Shipcompany.class)
public class Shipcompany_ { 

    public static volatile SingularAttribute<Shipcompany, Integer> companyId;
    public static volatile CollectionAttribute<Shipcompany, ItemOrder> itemOrderCollection;
    public static volatile SingularAttribute<Shipcompany, Company> company;
    public static volatile SingularAttribute<Shipcompany, String> deliverType;

}