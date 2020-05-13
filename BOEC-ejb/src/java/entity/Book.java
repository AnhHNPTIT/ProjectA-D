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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByPublishingYear", query = "SELECT b FROM Book b WHERE b.publishingYear = :publishingYear"),
    @NamedQuery(name = "Book.findBySku", query = "SELECT b FROM Book b WHERE b.sku = :sku"),
    @NamedQuery(name = "Book.findBySize", query = "SELECT b FROM Book b WHERE b.size = :size"),
    @NamedQuery(name = "Book.findByPageNumber", query = "SELECT b FROM Book b WHERE b.pageNumber = :pageNumber"),
    @NamedQuery(name = "Book.findByItemId", query = "SELECT b FROM Book b WHERE b.itemId = :itemId"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PublishingYear")
    @Temporal(TemporalType.DATE)
    private Date publishingYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKU")
    private int sku;
    @Size(max = 255)
    @Column(name = "Size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PageNumber")
    private int pageNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ItemId")
    private Integer itemId;
    @Size(max = 255)
    @Column(name = "Author")
    private String author;
    @JoinColumn(name = "ItemId", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Book() {
    }

    public Book(Integer itemId) {
        this.itemId = itemId;
    }

    public Book(Integer itemId, int sku, int pageNumber) {
        this.itemId = itemId;
        this.sku = sku;
        this.pageNumber = pageNumber;
    }

    public Date getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Date publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Book[ itemId=" + itemId + " ]";
    }
    
}
