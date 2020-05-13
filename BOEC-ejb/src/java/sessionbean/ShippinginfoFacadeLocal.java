/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Shippinginfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface ShippinginfoFacadeLocal {

    void create(Shippinginfo shippinginfo);

    void edit(Shippinginfo shippinginfo);

    void remove(Shippinginfo shippinginfo);

    Shippinginfo find(Object id);

    List<Shippinginfo> findAll();

    List<Shippinginfo> findRange(int[] range);

    int count();
    
}
