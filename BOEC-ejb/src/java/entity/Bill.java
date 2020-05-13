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
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByEmployeePersonId", query = "SELECT b FROM Bill b WHERE b.employeePersonId = :employeePersonId"),
    @NamedQuery(name = "Bill.findBySumary", query = "SELECT b FROM Bill b WHERE b.sumary = :sumary"),
    @NamedQuery(name = "Bill.findByDate", query = "SELECT b FROM Bill b WHERE b.date = :date"),
    @NamedQuery(name = "Bill.findByNote", query = "SELECT b FROM Bill b WHERE b.note = :note"),
    @NamedQuery(name = "Bill.findByOrderShipCompanyCompanyId", query = "SELECT b FROM Bill b WHERE b.orderShipCompanyCompanyId = :orderShipCompanyCompanyId"),
    @NamedQuery(name = "Bill.findByEmployeeId", query = "SELECT b FROM Bill b WHERE b.employeeId = :employeeId")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmployeePersonId")
    private int employeePersonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sumary")
    private float sumary;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;
    @Column(name = "OrderShipCompanyCompanyId")
    private Integer orderShipCompanyCompanyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmployeeId")
    private int employeeId;
    @JoinColumn(name = "EmployeePersonId2", referencedColumnName = "PersonId")
    @ManyToOne(optional = false)
    private Employee employeePersonId2;
    @JoinColumn(name = "ItemOrderId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private ItemOrder orderId;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, int employeePersonId, float sumary, int employeeId) {
        this.id = id;
        this.employeePersonId = employeePersonId;
        this.sumary = sumary;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeePersonId() {
        return employeePersonId;
    }

    public void setEmployeePersonId(int employeePersonId) {
        this.employeePersonId = employeePersonId;
    }

    public float getSumary() {
        return sumary;
    }

    public void setSumary(float sumary) {
        this.sumary = sumary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getOrderShipCompanyCompanyId() {
        return orderShipCompanyCompanyId;
    }

    public void setOrderShipCompanyCompanyId(Integer orderShipCompanyCompanyId) {
        this.orderShipCompanyCompanyId = orderShipCompanyCompanyId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployeePersonId2() {
        return employeePersonId2;
    }

    public void setEmployeePersonId2(Employee employeePersonId2) {
        this.employeePersonId2 = employeePersonId2;
    }

    public ItemOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(ItemOrder orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bill[ id=" + id + " ]";
    }
    
}
