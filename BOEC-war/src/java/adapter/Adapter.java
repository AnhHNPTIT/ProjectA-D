/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import entity.*;

/**
 *
 * @author skull
 */
public class Adapter implements ItemAdapter{
    
    Item item;
    Book book;
    Electronics electronic;
    Clothes clothes;
    
    public Adapter(String type){
        if(type.equals("book")){
            book=new Book();
        }
        if(type.equals("electronic")){
            electronic=new Electronics();
        }
        if(type.equals("clothes")){
            clothes=new Clothes();
        }
    }
    @Override
    public Item get(String type, Item item) {
        System.out.println("GETTING "+type+ " "+item.getName());
        if(type.equals("book") && item.getBook()!=null){
            System.out.println("THIS IS BOOK");
            return item.getBook().getItem();
        }
        else if(type.equals("electronic")&& item.getElectronics()!=null){
            System.out.println("THIS IS ELECTrONIC");
            return item.getElectronics().getItem();
        }
        else if(type.equals("clothes") && item.getClothes()!=null){
            System.out.println("THIS IS CLOTHES");
            return item.getClothes().getItem();
        }
        return null;
    }
    
}
