/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Account;
import entity.Cart;
import entity.CartItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author skull
 */
@Stateless
public class CartItemFacade extends AbstractFacade<CartItem> implements CartItemFacadeLocal {
    @PersistenceContext(unitName = "BOEC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartItemFacade() {
        super(CartItem.class);
    }

    @Override
    public List<CartItem> fetchByCart(Cart cart) {
         String jpql = "Select u From CartItem u Where u.cartId=:cart";
        Query query = em.createQuery(jpql);
        query.setParameter("cart", cart.getId());
        List<CartItem> list=new ArrayList<CartItem>();
        
        list=query.getResultList();
        
        return list;
    }
    
}
