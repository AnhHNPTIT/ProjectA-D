/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.ItemOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface ItemOrderFacadeLocal {

    void create(ItemOrder itemOrder);

    void edit(ItemOrder itemOrder);

    void remove(ItemOrder itemOrder);

    ItemOrder find(Object id);

    List<ItemOrder> findAll();

    List<ItemOrder> findRange(int[] range);

    int count();
    
}
