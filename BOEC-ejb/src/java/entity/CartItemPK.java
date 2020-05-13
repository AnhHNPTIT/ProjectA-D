/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author skull
 */
@Embeddable
public class CartItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ItemId")
    private int itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CartId")
    private int cartId;

    public CartItemPK() {
    }

    public CartItemPK(int itemId, int cartId) {
        this.itemId = itemId;
        this.cartId = cartId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemId;
        hash += (int) cartId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartItemPK)) {
            return false;
        }
        CartItemPK other = (CartItemPK) object;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.cartId != other.cartId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CartItemPK[ itemId=" + itemId + ", cartId=" + cartId + " ]";
    }
    
}
