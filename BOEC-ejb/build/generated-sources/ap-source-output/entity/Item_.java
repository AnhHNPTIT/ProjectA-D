package entity;

import entity.Book;
import entity.CartItem;
import entity.Category;
import entity.Clothes;
import entity.Company;
import entity.Electronics;
import entity.Promotions;
import entity.Shippinginfo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Electronics> electronics;
    public static volatile SingularAttribute<Item, Long> quantity;
    public static volatile CollectionAttribute<Item, Promotions> promotionsCollection;
    public static volatile SingularAttribute<Item, Book> book;
    public static volatile CollectionAttribute<Item, Shippinginfo> shippinginfoCollection;
    public static volatile SingularAttribute<Item, Date> productDate;
    public static volatile SingularAttribute<Item, Clothes> clothes;
    public static volatile SingularAttribute<Item, String> imageURI;
    public static volatile SingularAttribute<Item, Company> companyId;
    public static volatile CollectionAttribute<Item, CartItem> cartItemCollection;
    public static volatile SingularAttribute<Item, Float> price;
    public static volatile SingularAttribute<Item, String> intro;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, Category> categoryId;

}