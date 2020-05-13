/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Account;
import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author skull
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "BOEC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public Customer findCustomerByAccount(Account account) {
        Customer customer = null;
        List<Customer> list=findAll();
        for(int i=0;i<list.size();i++){
            System.out.println("i: "+i+"   "+list.get(i).getAccountId().getId());
            if(list.get(i).getAccountId().getId()==account.getId()){
                return list.get(i);
            }
        }
//         String username=account.getUsername();
//        String password=account.getPassword();
//        String jpql = "Select u From Customer Where u.accountId=:accountId";
//        Query query = em.createQuery(jpql);
//        query.setParameter("accountId", account.getId());
//        
//        Customer temp=(Customer) query.getSingleResult();
//        customer=new Customer.Builder().
//                intro(temp.getIntro()).
//                type(temp.getType()).
//                account(account).
//                personId(temp.getPersonId()).
//                build();
//        
        return customer;
        
        
    }
    
}
