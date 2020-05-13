/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skull
 */
@Entity
@Table(name = "cart_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartItem.findAll", query = "SELECT c FROM CartItem c"),
    @NamedQuery(name = "CartItem.findByQuantity", query = "SELECT c FROM CartItem c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CartItem.findByItemId", query = "SELECT c FROM CartItem c WHERE c.cartItemPK.itemId = :itemId"),
    @NamedQuery(name = "CartItem.findByCartId", query = "SELECT c FROM CartItem c WHERE c.cartItemPK.cartId = :cartId")})
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartItemPK cartItemPK;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "ItemId", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "CartId", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cart cart;

    public CartItem() {
    }

    public CartItem(CartItemPK cartItemPK) {
        this.cartItemPK = cartItemPK;
    }

    public CartItem(int itemId, int cartId) {
        this.cartItemPK = new CartItemPK(itemId, cartId);
    }

    public CartItemPK getCartItemPK() {
        return cartItemPK;
    }

    public void setCartItemPK(CartItemPK cartItemPK) {
        this.cartItemPK = cartItemPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartItemPK != null ? cartItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartItem)) {
            return false;
        }
        CartItem other = (CartItem) object;
        if ((this.cartItemPK == null && other.cartItemPK != null) || (this.cartItemPK != null && !this.cartItemPK.equals(other.cartItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CartItem[ cartItemPK=" + cartItemPK + " ]";
    }
    
}
