/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controller.LoginServlet;
import entity.Account;
import entity.Address;
import entity.Cart;
import entity.Customer;
import entity.Fullname;
import entity.Person;

/**
 *
 * @author skull
 */
public class PersonLoginFacade implements LoginFacadeInterface{
    LoginServlet loginServlet;
    Account account;
    public PersonLoginFacade(LoginServlet loginServlet,Account account){
        this.loginServlet=loginServlet;
        this.account=account;
    }
    
    /// HAM LOGIN
    public Person Login(){
        Person person=null;
        // check login thanh cong
        if(loginServlet.accountDAO.checkLogin(account)){
            Customer customer=loginServlet.customerDAO.findCustomerByAccount(account);
            person=loginServlet.personDAO.find(customer.getPersonId());
            person.setCustomer(customer);
            customer.setPerson(person);
        }
        return person;
    }
}
