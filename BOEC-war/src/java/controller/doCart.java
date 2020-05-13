/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Cart;
import entity.CartItem;
import entity.Item;
import iterator.SearchManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.CartItemFacadeLocal;

/**
 *
 * @author skull
 */
public class doCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private CartItemFacadeLocal cartItemDAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doCart at " + request.getContextPath() + "</h1>");
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
        String selectedItem=(String) request.getParameter("index");
        System.out.println("SELECT: "+selectedItem);
        SearchManager.Instance.Init();
        Item item=SearchManager.Instance.Find(Integer.parseInt(selectedItem));
        System.out.println("SELECT ITEM: "+item.getName());
        
        CartItem temp=new CartItem(item.getId(), CartController.Instance.cart.getId());
        //neu nhu da co item trong gio hang
        if(cartItemDAO.find(temp.getCartItemPK())!=null){
            cartItemDAO.edit(AddToCart(item));
        }
        //neu nhu chua co trong gio hang
        else{
            cartItemDAO.create(AddToCart(item));

        }
        
        
        
        
        
        
        request.getRequestDispatcher("cartPage.jsp").forward(request, response);
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
        
    }
    
    
    CartItem AddToCart(Item item){
       return CartController.Instance.AddToCart(item);
        
        
        
    }
}
