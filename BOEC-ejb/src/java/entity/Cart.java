/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findById", query = "SELECT c FROM Cart c WHERE c.id = :id"),
    @NamedQuery(name = "Cart.findByTotalPrice", query = "SELECT c FROM Cart c WHERE c.totalPrice = :totalPrice"),
    @NamedQuery(name = "Cart.findByNote", query = "SELECT c FROM Cart c WHERE c.note = :note")})
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPrice")
    private float totalPrice;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "CustomerPersonId", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Customer customerPersonId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartId")
    private Collection<ItemOrder> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Collection<CartItem> cartItemCollection;

    public Cart() {
    }
    public Cart(Builder builder){
        id=builder.id;
        note=builder.note;
        customerPersonId=builder.customerPersonId;
        totalPrice=builder.totalPrice;
    }
    public Cart(Integer id) {
        this.id = id;
    }

    public Cart(Integer id, float totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customer getCustomerPersonId() {
        return customerPersonId;
    }

    public void setCustomerPersonId(Customer customerPersonId) {
        this.customerPersonId = customerPersonId;
    }

    @XmlTransient
    public Collection<ItemOrder> getItemOrderCollection() {
        return order1Collection;
    }

    public void setItemOrderCollection(Collection<ItemOrder> order1Collection) {
        this.order1Collection = order1Collection;
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
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cart[ id=" + id + " ]";
    }
    public static class Builder{
        private Integer id;
        private float totalPrice;
        private String note;
        private Customer customerPersonId;
    
        public Builder()
        {
        }
        public Cart build(){
            return new Cart(this);
        }
        
        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder totalPrice(float totalPrice){
            this.totalPrice=totalPrice;
            return this;
        }
        public Builder customerPersonId(Customer customerPersonId){
            this.customerPersonId=customerPersonId;
            return this;
        }
       public Builder note(String note){
            this.note=note;
            return this;
        }
       
    
    
    }
}
