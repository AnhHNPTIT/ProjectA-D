/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.ItemOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.CartFacadeLocal;
import sessionbean.ItemOrderFacadeLocal;

/**
 *
 * @author skull
 */
public class doPurchase extends HttpServlet {

    @EJB
    private ItemOrderFacadeLocal orderDAO;
    @EJB
    private CartFacadeLocal cartDAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doPurchase</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doPurchase at " + request.getContextPath() + "</h1>");
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
        String paymentType=request.getParameter("paymentType");
        PlaceOrder(CartController.Instance.cart,paymentType);
        request.getRequestDispatcher("homePage.jsp").forward(request, response);

    }

    void PlaceOrder(Cart cart,String paymentType){
        try{
            ItemOrder order=new ItemOrder();
            order.setShippingFee(200.5f);
            order.setCartId(cart);
            order.setNote("ordering");
            order.setOrderTime(LocalDateTime.now().toString());
            LocalDate ldt=LocalDateTime.now().toLocalDate().plusDays(10);
            Date placedDate=new Date(ldt.getYear(),ldt.getMonthValue(),ldt.getDayOfMonth());
            order.setPalcedOn(placedDate);
            order.setPaymentType(paymentType);
            order.setStatus("delivering");
            orderDAO.create(order);
            
            // set thuoc tinh cart da dc order
            cart.setNote("ordered");
            cartDAO.edit(cart);
            
            // tao lai 1 cart khac
            Cart newCart=cartDAO.checkCartForCustomer(cart.getCustomerPersonId());
            CartController.Instance.CreateCart(newCart);
        }
        catch (Exception e){
            
        }

    }
}
