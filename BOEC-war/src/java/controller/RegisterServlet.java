/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Address;
import entity.Customer;
import entity.Fullname;
import entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.AccountFacadeLocal;
import sessionbean.AddressFacadeLocal;
import sessionbean.CustomerFacadeLocal;
import sessionbean.FullnameFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author skull
 */
public class RegisterServlet extends HttpServlet {
    @EJB
    FullnameFacadeLocal fullnameDAO;
     
     
    @EJB
    PersonFacadeLocal personDAO;
    @EJB
    CustomerFacadeLocal customerDAO;
    @EJB
    AccountFacadeLocal accountDAO;
   
    @EJB
    AddressFacadeLocal addressDAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("fullname: "+(fullnameDAO==null));
            List<Fullname> listfn=fullnameDAO.findAll();
            System.out.println("SIZE: "+listfn.size());
            for(int i=0;i<listfn.size();i++){
                System.out.println("FULLNAME: "+i+"  "+listfn.get(i).getFirstName());
            }
        System.out.println("REGISTERING");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phonenumber");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastname");
        String id = request.getParameter("identifynumber");
        String email = request.getParameter("email");
        int number=0;
        try{
            number = Integer.parseInt(request.getParameter("number"));
        }catch(Exception e){
            
        }
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String country = request.getParameter("country");
        String street = request.getParameter("street");
        
        username="test";
        password="test";
        birthday="1996-05-05";
        gender="nam";
        phoneNumber="124124";
        name="yoyoyo";
        lastName="YOYOYO";
        id="41212";
        number=123;
        city="hanoi";
        district="hadong";
        country="vietnam";
        street="nguyentrai";
        email="412414@gmail.com";
        System.out.println("username: "+username+ "   password: "+password);

        int personID=personDAO.count()+1;
        int fullnameID=fullnameDAO.count()+1;
        int addressID=addressDAO.count()+1;
        int customerID=customerDAO.count()+1;
        int accountID=accountDAO.count()+1;
        System.out.println("COUNT: "+personID+ " "+customerID+" "+accountID);
        Fullname fullname=new Fullname.Builder(name, lastName).build();
        Address address=new Address.Builder().city(city).country(country).district(district).street(street).number(number).build();
        Account account=new Account.Builder(username,password).build();
        
        Customer customer=new Customer.Builder().type("VIP").account(account).personId(personID).build();
        Person person= new Person.Builder(personID,fullname, address).customer(customer).build();
        customer.setPerson(person);

        if(RegisterNewPerson(person)){
            HttpSession session = request.getSession();
            request.setAttribute("username", username);
            session.setAttribute("user", username);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("invalid.jsp").forward(request, response);

        }
        
//        Fullname fn=new Fullname.Builder(7,"test1","test2").build();
//        Address ad=new Address.Builder(7).number(512).build();
//        Person person=new Person.Builder(3, fn,ad).build();
//        personDAO.create(person);
        System.out.println("SIGNING UP");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    boolean RegisterNewPerson(Person person){
         try{
            
             System.out.println("fullname:"+person.getFullNameId().getId());
            fullnameDAO.create(person.getFullNameId());
            System.out.println("address:"+person.getAddressId().getId());

            addressDAO.create(person.getAddressId());
            System.out.println("account:"+person.getCustomer().getAccountId().getId());
            accountDAO.create(person.getCustomer().getAccountId());
             System.out.println("person: "+person.getId()+ " "+person.getFullNameId().getId()+ " "+person.getAddressId().getId());
             
            Fullname testfn=fullnameDAO.find(person.getFullNameId().getId());
             System.out.println("fullname TEST: "+testfn.getFirstName());
             Address testadd=addressDAO.find(person.getAddressId().getId());
             System.out.println("address TEST: "+testadd.getNumber());
             System.out.println("person TEST: "+(person==null)+ " "+(person.getCustomer()==null) +" "+person.getCustomer().getPerson().getFullNameId().getFirstName());
            personDAO.create(person);

//             System.out.println("CUstomer: "+person.getCustomer().getPersonId());
//            customerDAO.create(person.getCustomer());
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
