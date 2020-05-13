/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author skull
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
    @PersistenceContext(unitName = "BOEC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    @Override
    public boolean checkLogin(Account account) {
        String username=account.getUsername();
        String password=account.getPassword();
        String jpql = "Select u From Account u Where u.username=:username and u.password=:password";
        Query query = em.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            Account t=(Account)query.getSingleResult();
            account.setId(t.getId());
            
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
