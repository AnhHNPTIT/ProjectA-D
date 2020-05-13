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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "fullname")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fullname.findAll", query = "SELECT f FROM Fullname f"),
    @NamedQuery(name = "Fullname.findById", query = "SELECT f FROM Fullname f WHERE f.id = :id"),
    @NamedQuery(name = "Fullname.findByFirstName", query = "SELECT f FROM Fullname f WHERE f.firstName = :firstName"),
    @NamedQuery(name = "Fullname.findByLastName", query = "SELECT f FROM Fullname f WHERE f.lastName = :lastName")})
public class Fullname implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 255)
    @Column(name = "LastName")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fullNameId")
    private Collection<Person> personCollection;

    public Fullname() {
    }
    public Fullname(Builder builder){
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
    }
    public Fullname(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
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
        if (!(object instanceof Fullname)) {
            return false;
        }
        Fullname other = (Fullname) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fullname[ id=" + id + " ]";
    }
    public static class Builder{
        private Integer id;
        private String firstName,lastName;
        public Builder(String firstName,String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
        }
        public Fullname build(){
            return new Fullname(this);
        }
        
        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }
    }
}
