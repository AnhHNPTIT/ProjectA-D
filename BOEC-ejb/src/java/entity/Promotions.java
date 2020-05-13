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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "promotions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p"),
    @NamedQuery(name = "Promotions.findById", query = "SELECT p FROM Promotions p WHERE p.id = :id"),
    @NamedQuery(name = "Promotions.findByDiscount", query = "SELECT p FROM Promotions p WHERE p.discount = :discount"),
    @NamedQuery(name = "Promotions.findByFromDiscount", query = "SELECT p FROM Promotions p WHERE p.fromDiscount = :fromDiscount"),
    @NamedQuery(name = "Promotions.findByEndDiscount", query = "SELECT p FROM Promotions p WHERE p.endDiscount = :endDiscount"),
    @NamedQuery(name = "Promotions.findByPriceAfterDiscount", query = "SELECT p FROM Promotions p WHERE p.priceAfterDiscount = :priceAfterDiscount")})
public class Promotions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Discount")
    private String discount;
    @Column(name = "FromDiscount")
    @Temporal(TemporalType.DATE)
    private Date fromDiscount;
    @Column(name = "EndDiscount")
    @Temporal(TemporalType.DATE)
    private Date endDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PriceAfterDiscount")
    private float priceAfterDiscount;
    @ManyToMany(mappedBy = "promotionsCollection")
    private Collection<Item> itemCollection;

    public Promotions() {
    }

    public Promotions(Integer id) {
        this.id = id;
    }

    public Promotions(Integer id, String discount, float priceAfterDiscount) {
        this.id = id;
        this.discount = discount;
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getFromDiscount() {
        return fromDiscount;
    }

    public void setFromDiscount(Date fromDiscount) {
        this.fromDiscount = fromDiscount;
    }

    public Date getEndDiscount() {
        return endDiscount;
    }

    public void setEndDiscount(Date endDiscount) {
        this.endDiscount = endDiscount;
    }

    public float getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(float priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
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
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Promotions[ id=" + id + " ]";
    }
    
}
