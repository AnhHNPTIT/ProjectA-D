/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import entity.Book;
import entity.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author skull
 */
public class SearchManager {
    //singleton
    public static SearchManager Instance;
    public Iterator allItem;
    List<Item> listItem;
    public SearchManager(List<Item> listItem){
        if(Instance==null){
            Instance=this;
            this.listItem=listItem;
        }
    }
    public void Init(){
        //ITERATOR
        allItem=new AllItemIterator(listItem);
    }
   
    public Item Find(int id){
   
        while (allItem.hasNext()) 
        { 
            Item current = (Item) allItem.next(); 
            if(current.getId()==id){
                return current;
            }
            
        }
        return null;
    }
    public List<Item> Find(String name){
        List<Item> list=new ArrayList<Item>();
        
        while (allItem.hasNext()) 
        { 
            Item current = (Item) allItem.next(); 
            
            if(current.getName().toLowerCase().contains(name.toLowerCase()) || name.equals("all")){
                list.add(current);
            }
            
        }
        
        return list;
    }
    public void ShowAll(){
        int row=1;
        while (allItem.hasNext()) 
        { 
            Item current = (Item) allItem.next(); 
            int id=row;
            String name=current.getName();
            float price=current.getPrice();
            long quantity=current.getQuantity();
            System.out.println("SHOW SHOW: "+name);
        }
    }
    
}
