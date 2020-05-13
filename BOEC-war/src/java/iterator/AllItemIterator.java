/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import entity.Item;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 *
 * @author skull
 */
public class AllItemIterator implements Iterator{
    private Vector data;
    Enumeration<Item> ec;
    Item nextItem;
    public AllItemIterator(List<Item> listItem){
        Init(listItem);
        ec=data.elements();
    }
    
    // KHOI TAO DU LIEU CHO VAO VECTOR DATA
    public void Init(List<Item> listItem){
        data=new Vector();
        for(Item item : listItem){
            data.add(item);
            System.out.println("INIT : "+item.getName());
        }
    }
    @Override
    public boolean hasNext() {
        boolean matchFound = false; 
        nextItem = null;
        
        while (ec.hasMoreElements()) 
        { 
            Item tempObj = (Item) ec.nextElement(); 
            nextItem = tempObj; 
            break; 
        } 
        
        return (nextItem != null);
    }

    @Override
    public Object next() {
        if (nextItem == null)
        { 
            throw new NoSuchElementException(); 
        } 
        else 
        { 
            return nextItem;
        }

    
    }
    public void remove(Item item){
        
    }
    
}
