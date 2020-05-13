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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "shipcompany")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipcompany.findAll", query = "SELECT s FROM Shipcompany s"),
    @NamedQuery(name = "Shipcompany.findByDeliverType", query = "SELECT s FROM Shipcompany s WHERE s.deliverType = :deliverType"),
    @NamedQuery(name = "Shipcompany.findByCompanyId", query = "SELECT s FROM Shipcompany s WHERE s.companyId = :companyId")})
public class Shipcompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "DeliverType")
    private String deliverType;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CompanyId")
    private Integer companyId;
    @JoinTable(name = "order_shipcompany", joinColumns = {
        @JoinColumn(name = "ShipCompanyCompanyId", referencedColumnName = "CompanyId")}, inverseJoinColumns = {
        @JoinColumn(name = "ItemOrderId", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<ItemOrder> itemOrderCollection;
    @JoinColumn(name = "CompanyId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Company company;

    public Shipcompany() {
    }

    public Shipcompany(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(String deliverType) {
        this.deliverType = deliverType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public Collection<ItemOrder> getItemOrderCollection() {
        return itemOrderCollection;
    }

    public void setItemOrderCollection(Collection<ItemOrder> itemOrderCollection) {
        this.itemOrderCollection = itemOrderCollection;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipcompany)) {
            return false;
        }
        Shipcompany other = (Shipcompany) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shipcompany[ companyId=" + companyId + " ]";
    }
    
}
