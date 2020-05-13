/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Electronics;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author skull
 */
@Stateless
public class ElectronicsFacade extends AbstractFacade<Electronics> implements ElectronicsFacadeLocal {
    @PersistenceContext(unitName = "BOEC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectronicsFacade() {
        super(Electronics.class);
    }
    
}
