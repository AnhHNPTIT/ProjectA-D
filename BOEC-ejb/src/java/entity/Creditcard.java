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
@Table(name = "creditcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c"),
    @NamedQuery(name = "Creditcard.findById", query = "SELECT c FROM Creditcard c WHERE c.id = :id"),
    @NamedQuery(name = "Creditcard.findByCustomerPersonId", query = "SELECT c FROM Creditcard c WHERE c.customerPersonId = :customerPersonId"),
    @NamedQuery(name = "Creditcard.findByCardNumber", query = "SELECT c FROM Creditcard c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "Creditcard.findByType", query = "SELECT c FROM Creditcard c WHERE c.type = :type"),
    @NamedQuery(name = "Creditcard.findByExpireDate", query = "SELECT c FROM Creditcard c WHERE c.expireDate = :expireDate"),
    @NamedQuery(name = "Creditcard.findByCustomerId", query = "SELECT c FROM Creditcard c WHERE c.customerId = :customerId")})
public class Creditcard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerPersonId")
    private int customerPersonId;
    @Size(max = 255)
    @Column(name = "CardNumber")
    private String cardNumber;
    @Size(max = 255)
    @Column(name = "Type")
    private String type;
    @Column(name = "ExpireDate")
    @Temporal(TemporalType.DATE)
    private Date expireDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private int customerId;
    @JoinColumn(name = "CustomerPersonId2", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Customer customerPersonId2;

    public Creditcard() {
    }

    public Creditcard(Integer id) {
        this.id = id;
    }

    public Creditcard(Integer id, int customerPersonId, int customerId) {
        this.id = id;
        this.customerPersonId = customerPersonId;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomerPersonId() {
        return customerPersonId;
    }

    public void setCustomerPersonId(int customerPersonId) {
        this.customerPersonId = customerPersonId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomerPersonId2() {
        return customerPersonId2;
    }

    public void setCustomerPersonId2(Customer customerPersonId2) {
        this.customerPersonId2 = customerPersonId2;
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
        if (!(object instanceof Creditcard)) {
            return false;
        }
        Creditcard other = (Creditcard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Creditcard[ id=" + id + " ]";
    }
    
}
