/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "voucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voucher.findAll", query = "SELECT v FROM Voucher v"),
    @NamedQuery(name = "Voucher.findById", query = "SELECT v FROM Voucher v WHERE v.id = :id"),
    @NamedQuery(name = "Voucher.findByCouponValue", query = "SELECT v FROM Voucher v WHERE v.couponValue = :couponValue"),
    @NamedQuery(name = "Voucher.findByLimitedValue", query = "SELECT v FROM Voucher v WHERE v.limitedValue = :limitedValue"),
    @NamedQuery(name = "Voucher.findByQuantity", query = "SELECT v FROM Voucher v WHERE v.quantity = :quantity")})
public class Voucher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CouponValue")
    private int couponValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LimitedValue")
    private long limitedValue;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinTable(name = "customer_voucher", joinColumns = {
        @JoinColumn(name = "VoucherId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "CustomerPersonId", referencedColumnName = "PersonId")})
    @ManyToMany
    private Collection<Customer> customerCollection;

    public Voucher() {
    }

    public Voucher(Integer id) {
        this.id = id;
    }

    public Voucher(Integer id, int couponValue, long limitedValue) {
        this.id = id;
        this.couponValue = couponValue;
        this.limitedValue = limitedValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(int couponValue) {
        this.couponValue = couponValue;
    }

    public long getLimitedValue() {
        return limitedValue;
    }

    public void setLimitedValue(long limitedValue) {
        this.limitedValue = limitedValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
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
        if (!(object instanceof Voucher)) {
            return false;
        }
        Voucher other = (Voucher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Voucher[ id=" + id + " ]";
    }
    
}
