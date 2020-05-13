/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Shipcompany;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface ShipcompanyFacadeLocal {

    void create(Shipcompany shipcompany);

    void edit(Shipcompany shipcompany);

    void remove(Shipcompany shipcompany);

    Shipcompany find(Object id);

    List<Shipcompany> findAll();

    List<Shipcompany> findRange(int[] range);

    int count();
    
}
