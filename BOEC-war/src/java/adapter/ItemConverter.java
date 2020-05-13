/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import entity.Item;

/**
 *
 * @author skull
 */
public class ItemConverter implements ItemAdapter{
    ItemAdapter adapter;
    @Override
    public Item get(String type, Item item) {
        System.out.println("ITEM ITEM : "+type);
        adapter =new Adapter(type);
        Item newItem=adapter.get(type, item);
        return newItem;
    }
    
}
