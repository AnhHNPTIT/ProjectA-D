/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByDob", query = "SELECT p FROM Person p WHERE p.dob = :dob"),
    @NamedQuery(name = "Person.findByPhoneNumber", query = "SELECT p FROM Person p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @NamedQuery(name = "Person.findByImageURI", query = "SELECT p FROM Person p WHERE p.imageURI = :imageURI"),
    @NamedQuery(name = "Person.findByIdentifyNumber", query = "SELECT p FROM Person p WHERE p.identifyNumber = :identifyNumber")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 255)
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @Size(max = 255)
    @Column(name = "Gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "ImageURI")
    private String imageURI;
    @Size(max = 20)
    @Column(name = "IdentifyNumber")
    private String identifyNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Employee employee;
    @JoinColumn(name = "AddressId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "FullNameId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Fullname fullNameId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Customer customer;

    public Person() {
    }
    public Person(Builder builder) {
        id=builder.id;
        fullNameId=builder.fullNameId;
        addressId=builder.addressId;
        employee=builder.employee;
        customer=builder.customer;
        dob=builder.dob;
        email=builder.email;
        identifyNumber=builder.identifyNumber;
        imageURI=builder.imageURI;
        phoneNumber=builder.phoneNumber;
        gender=builder.gender;
    }
    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Fullname getFullNameId() {
        return fullNameId;
    }

    public void setFullNameId(Fullname fullNameId) {
        this.fullNameId = fullNameId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ id=" + id + " ]";
    }
    public static class Builder{
        private Integer id;
        private Date dob;
        private String phoneNumber;
        private String email;
        private String gender;
        private String imageURI;
        private String identifyNumber;
        private Employee employee;
        private Address addressId;
        private Fullname fullNameId;
        private Customer customer;
        public Builder(Integer id,Fullname fullName,Address address){
            this.addressId=address;
            this.fullNameId=fullName;
            this.id=id;
        }
        public Person build(){
            return new Person(this);
        }
        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder dob(Date dob){
            this.dob=dob;
            return this;
        }
        public Builder gender(String gender){
            this.gender=gender;
            return this;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder identifyNumber(String identifyNumber){
            this.identifyNumber=identifyNumber;
            return this;
        }
        public Builder imageURI(String imageURI){
            this.imageURI=imageURI;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer=customer;
            return this;
        }
        public Builder fullName(Fullname fullNameId){
            this.fullNameId=fullNameId;
            return this;
        }
        public Builder addressId(Address addressId){
            this.addressId=addressId;
            return this;
        }
        public Builder employee(Employee employee){
            this.employee=employee;
            return this;
        }
    }
}
