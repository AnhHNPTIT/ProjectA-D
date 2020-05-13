/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Shipcompany;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author skull
 */
@Stateless
public class ShipcompanyFacade extends AbstractFacade<Shipcompany> implements ShipcompanyFacadeLocal {
    @PersistenceContext(unitName = "BOEC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShipcompanyFacade() {
        super(Shipcompany.class);
    }
    
}
