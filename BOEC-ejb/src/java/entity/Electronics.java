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
@Table(name = "electronics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electronics.findAll", query = "SELECT e FROM Electronics e"),
    @NamedQuery(name = "Electronics.findByTechnology", query = "SELECT e FROM Electronics e WHERE e.technology = :technology"),
    @NamedQuery(name = "Electronics.findByPower", query = "SELECT e FROM Electronics e WHERE e.power = :power"),
    @NamedQuery(name = "Electronics.findByColor", query = "SELECT e FROM Electronics e WHERE e.color = :color"),
    @NamedQuery(name = "Electronics.findBySize", query = "SELECT e FROM Electronics e WHERE e.size = :size"),
    @NamedQuery(name = "Electronics.findByType", query = "SELECT e FROM Electronics e WHERE e.type = :type"),
    @NamedQuery(name = "Electronics.findByItemId", query = "SELECT e FROM Electronics e WHERE e.itemId = :itemId")})
public class Electronics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Technology")
    private String technology;
    @Size(max = 255)
    @Column(name = "Power")
    private String power;
    @Size(max = 255)
    @Column(name = "Color")
    private String color;
    @Size(max = 255)
    @Column(name = "Size")
    private String size;
    @Size(max = 255)
    @Column(name = "Type")
    private String type;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ItemId")
    private Integer itemId;
    @JoinColumn(name = "ItemId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Electronics() {
    }

    public Electronics(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Electronics)) {
            return false;
        }
        Electronics other = (Electronics) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Electronics[ itemId=" + itemId + " ]";
    }
    
}
