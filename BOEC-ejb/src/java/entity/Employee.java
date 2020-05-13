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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByPosition", query = "SELECT e FROM Employee e WHERE e.position = :position"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary"),
    @NamedQuery(name = "Employee.findByPersonId", query = "SELECT e FROM Employee e WHERE e.personId = :personId")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salary")
    private float salary;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonId")
    private Integer personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeePersonId2")
    private Collection<Bill> billCollection;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "DepartmentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Department departmentId;
    @JoinColumn(name = "RankId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Rank rankId;
    @JoinColumn(name = "PersonId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Employee() {
    }

    public Employee(Integer personId) {
        this.personId = personId;
    }

    public Employee(Integer personId, float salary) {
        this.personId = personId;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public Rank getRankId() {
        return rankId;
    }

    public void setRankId(Rank rankId) {
        this.rankId = rankId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ personId=" + personId + " ]";
    }
    
}
