/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "item_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemOrder.findAll", query = "SELECT i FROM ItemOrder i"),
    @NamedQuery(name = "ItemOrder.findById", query = "SELECT i FROM ItemOrder i WHERE i.id = :id"),
    @NamedQuery(name = "ItemOrder.findByOrderTime", query = "SELECT i FROM ItemOrder i WHERE i.orderTime = :orderTime"),
    @NamedQuery(name = "ItemOrder.findByShippingFee", query = "SELECT i FROM ItemOrder i WHERE i.shippingFee = :shippingFee"),
    @NamedQuery(name = "ItemOrder.findByStatus", query = "SELECT i FROM ItemOrder i WHERE i.status = :status"),
    @NamedQuery(name = "ItemOrder.findByPalcedOn", query = "SELECT i FROM ItemOrder i WHERE i.palcedOn = :palcedOn"),
    @NamedQuery(name = "ItemOrder.findByPaymentType", query = "SELECT i FROM ItemOrder i WHERE i.paymentType = :paymentType"),
    @NamedQuery(name = "ItemOrder.findByNote", query = "SELECT i FROM ItemOrder i WHERE i.note = :note")})
public class ItemOrder implements Serializable {
    @JoinColumn(name = "CartId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Cart cartId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "OrderTime")
    private String orderTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShippingFee")
    private float shippingFee;
    @Size(max = 255)
    @Column(name = "Status")
    private String status;
    @Column(name = "PalcedOn")
    @Temporal(TemporalType.DATE)
    private Date palcedOn;
    @Size(max = 255)
    @Column(name = "PaymentType")
    private String paymentType;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;

    public ItemOrder() {
    }

    public ItemOrder(Integer id) {
        this.id = id;
    }

    public ItemOrder(Integer id, float shippingFee) {
        this.id = id;
        this.shippingFee = shippingFee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPalcedOn() {
        return palcedOn;
    }

    public void setPalcedOn(Date palcedOn) {
        this.palcedOn = palcedOn;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof ItemOrder)) {
            return false;
        }
        ItemOrder other = (ItemOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemOrder[ id=" + id + " ]";
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }
    
}
