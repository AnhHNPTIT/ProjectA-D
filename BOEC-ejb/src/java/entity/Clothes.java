/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "clothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c"),
    @NamedQuery(name = "Clothes.findByMaterial", query = "SELECT c FROM Clothes c WHERE c.material = :material"),
    @NamedQuery(name = "Clothes.findByBrand", query = "SELECT c FROM Clothes c WHERE c.brand = :brand"),
    @NamedQuery(name = "Clothes.findByTypeOfGender", query = "SELECT c FROM Clothes c WHERE c.typeOfGender = :typeOfGender"),
    @NamedQuery(name = "Clothes.findByItemId", query = "SELECT c FROM Clothes c WHERE c.itemId = :itemId")})
public class Clothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Material")
    private String material;
    @Size(max = 255)
    @Column(name = "Brand")
    private String brand;
    @Size(max = 255)
    @Column(name = "TypeOfGender")
    private String typeOfGender;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ItemId")
    private Integer itemId;
    @JoinColumn(name = "ItemId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Clothes() {
    }

    public Clothes(Integer itemId) {
        this.itemId = itemId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypeOfGender() {
        return typeOfGender;
    }

    public void setTypeOfGender(String typeOfGender) {
        this.typeOfGender = typeOfGender;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clothes[ itemId=" + itemId + " ]";
    }
    
}
