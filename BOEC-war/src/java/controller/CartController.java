/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.CartItem;
import entity.Item;
import entity.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skull
 */
public class CartController {
    public static CartController Instance;
    public Cart cart;
    private List<CartItem> listItem;
    public CartController(Cart cart){
        if(Instance==null){
            Instance=this;
            // lay toan bo item trong gio hang
            CreateCart(cart);
        }
        else{
            
        }
    }
    public void CreateCart(Cart cart){
        listItem=new ArrayList<>(cart.getCartItemCollection());
        this.cart=cart;
    }
    boolean CheckForDuplicate(CartItem item){
        for(CartItem ci : listItem){
            if(ci.toString().equals(item.toString())){
                System.out.println("DUPLICATE");
                return true;
            }
        }
        
        return false;
    }
    public CartItem AddToCart(Item item){
        try{
            CartItem ci=new CartItem(item.getId(), cart.getId());
            
            ci.setCart(cart);
            ci.setItem(item);
            ci.setQuantity(0);

            //neu nhu co roi
            if(CheckForDuplicate(ci)){
                
                // +1
                for(CartItem t : listItem){
                    if(t.toString().equals(ci.toString())){
                        t.setQuantity(t.getQuantity()+1);
                        ci.setQuantity(t.getQuantity());
                        
                        break;
                    }
                }
                
            }
            // chua co
            else{
                ci.setQuantity(1);
                listItem.add(ci);

            }
            return ci;
        }
        catch (Exception e){
            return null;
        }
    }
    public CartItem Remove(int position){
        try{
            CartItem ci=listItem.get(position);
            listItem.remove(position);
            return ci;
        }
        catch (Exception e){
            return null;
        }
    }
    public List<CartItem> GetAllItem(){
        return this.listItem;
    }
}
