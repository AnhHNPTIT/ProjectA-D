/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Creditcard;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface CreditcardFacadeLocal {

    void create(Creditcard creditcard);

    void edit(Creditcard creditcard);

    void remove(Creditcard creditcard);

    Creditcard find(Object id);

    List<Creditcard> findAll();

    List<Creditcard> findRange(int[] range);

    int count();
    
}
