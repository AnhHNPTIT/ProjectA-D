/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByIntro", query = "SELECT i FROM Item i WHERE i.intro = :intro"),
    @NamedQuery(name = "Item.findByQuantity", query = "SELECT i FROM Item i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "Item.findByProductDate", query = "SELECT i FROM Item i WHERE i.productDate = :productDate"),
    @NamedQuery(name = "Item.findByImageURI", query = "SELECT i FROM Item i WHERE i.imageURI = :imageURI")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Size(max = 255)
    @Column(name = "Intro")
    private String intro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private long quantity;
    @Column(name = "ProductDate")
    @Temporal(TemporalType.DATE)
    private Date productDate;
    @Size(max = 255)
    @Column(name = "ImageURI")
    private String imageURI;
    @JoinTable(name = "item_promotions", joinColumns = {
        @JoinColumn(name = "ItemId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "PromotionsId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Promotions> promotionsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Electronics electronics;
    @JoinColumn(name = "CompanyId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Clothes clothes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<Shippinginfo> shippinginfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<CartItem> cartItemCollection;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, float price, long quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    @XmlTransient
    public Collection<Promotions> getPromotionsCollection() {
        return promotionsCollection;
    }

    public void setPromotionsCollection(Collection<Promotions> promotionsCollection) {
        this.promotionsCollection = promotionsCollection;
    }

    public Electronics getElectronics() {
        return electronics;
    }

    public void setElectronics(Electronics electronics) {
        this.electronics = electronics;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    @XmlTransient
    public Collection<Shippinginfo> getShippinginfoCollection() {
        return shippinginfoCollection;
    }

    public void setShippinginfoCollection(Collection<Shippinginfo> shippinginfoCollection) {
        this.shippinginfoCollection = shippinginfoCollection;
    }

    @XmlTransient
    public Collection<CartItem> getCartItemCollection() {
        return cartItemCollection;
    }

    public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
        this.cartItemCollection = cartItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Item[ id=" + id + " ]";
    }
    
}
