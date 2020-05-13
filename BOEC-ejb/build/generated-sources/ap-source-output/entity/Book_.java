package entity;

import entity.Item;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T03:34:36")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> itemId;
    public static volatile SingularAttribute<Book, Item> item;
    public static volatile SingularAttribute<Book, Integer> pageNumber;
    public static volatile SingularAttribute<Book, String> size;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, Date> publishingYear;
    public static volatile SingularAttribute<Book, Integer> sku;

}