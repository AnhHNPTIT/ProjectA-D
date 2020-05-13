/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Account;
import entity.Cart;
import entity.CartItem;
import entity.CartItemPK;
import entity.Customer;
import entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author skull
 */
@Stateless
public class CartFacade extends AbstractFacade<Cart> implements CartFacadeLocal {
    
    List<CartItem> itemInCart;
    
    @PersistenceContext(unitName = "BOEC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartFacade() {
        super(Cart.class);
    }

    @PostConstruct
    void init(){
        itemInCart=new ArrayList<CartItem>();
    }
    
    @Override
    public Cart checkCartForCustomer(Customer customer) {
        Cart cart=null;

        String jpql = "Select u From Cart u Where u.customerPersonId=:personId And u.note=:note";
        Query query = em.createQuery(jpql);
        query.setParameter("personId", customer);
        query.setParameter("note", "waiting");
         try {
            cart=(Cart)query.getSingleResult();
            
        } catch (Exception e) {
             System.out.println("NO CART");
             cart=addNewCart(customer);
        }
         
         
        return cart ;

    }

    @Override
    public Cart addNewCart(Customer customer) {
        Cart cart=null;
        cart=new Cart.Builder().customerPersonId(customer).totalPrice(0).note("waiting").build();
        create(cart);
        
        return cart;
    }
    
    @Override
    public boolean addToCart(CartItem item){
        
        
        itemInCart.add(item);
        
        
        return false;
    }
    
    
    
}
