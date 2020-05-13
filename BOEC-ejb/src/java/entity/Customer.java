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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByIntro", query = "SELECT c FROM Customer c WHERE c.intro = :intro"),
    @NamedQuery(name = "Customer.findByType", query = "SELECT c FROM Customer c WHERE c.type = :type"),
    @NamedQuery(name = "Customer.findByPersonId", query = "SELECT c FROM Customer c WHERE c.personId = :personId")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Intro")
    private String intro;
    @Size(max = 255)
    @Column(name = "Type")
    private String type;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonId")
    private Integer personId;
    @ManyToMany(mappedBy = "customerCollection")
    private Collection<Voucher> voucherCollection;
    @JoinTable(name = "customer_notification", joinColumns = {
        @JoinColumn(name = "CustomerPersonId", referencedColumnName = "PersonId")}, inverseJoinColumns = {
        @JoinColumn(name = "NotificationId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Notification> notificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerPersonId2")
    private Collection<Creditcard> creditcardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerPersonId")
    private Collection<Cart> cartCollection;
    @JoinColumn(name = "PersonId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Account accountId;

    public Customer() {
    }
    public Customer(Builder builder){
        this.intro=builder.intro;
        this.type=builder.type;
        this.accountId=builder.accountId;
        this.personId=builder.personId;
    }
    public Customer(Integer personId) {
        this.personId = personId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @XmlTransient
    public Collection<Creditcard> getCreditcardCollection() {
        return creditcardCollection;
    }

    public void setCreditcardCollection(Collection<Creditcard> creditcardCollection) {
        this.creditcardCollection = creditcardCollection;
    }

    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ personId=" + personId + " ]";
    }
    
    public static class Builder{
        private String intro;
        private String type;
        private Account accountId;
        private Integer personId;
        public Builder(){
        }
        public Customer build(){
            return new Customer(this);
        }
        public Builder personId(int personId){
            this.personId=personId;
            return this;
        }
        public Builder intro(String intro){
            this.intro=intro;
            return this;
        }
        public Builder type(String type){
            this.type=type;
            return this;
        }
        public Builder account(Account account){
            this.accountId=account;
            return this;
        }
       
    
    
    }
}
