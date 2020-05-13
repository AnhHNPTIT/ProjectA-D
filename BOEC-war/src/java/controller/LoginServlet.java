
package controller;

import entity.Account;
import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Item;
import entity.Person;
import facade.LoginFacadeInterface;
import facade.PersonLoginFacade;
import iterator.SearchManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.AccountFacadeLocal;
import sessionbean.AddressFacadeLocal;
import sessionbean.CartFacadeLocal;
import sessionbean.CartItemFacadeLocal;
import sessionbean.CustomerFacadeLocal;
import sessionbean.FullnameFacadeLocal;
import sessionbean.ItemFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author skull
 */
public class LoginServlet extends HttpServlet {
    @EJB
    public AccountFacadeLocal accountDAO;
    @EJB
    public ItemFacadeLocal itemDAO;
    @EJB
    public CustomerFacadeLocal customerDAO;
    @EJB
    public PersonFacadeLocal personDAO;
    @EJB
    public FullnameFacadeLocal fullnameDAO;
    @EJB
    public CartFacadeLocal cartDAO;
    @EJB
    public AddressFacadeLocal addressDAO;
    @EJB
    public CartItemFacadeLocal cartItemDAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

        
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
        String type=request.getParameter("Btn");
        
        if(type!=null){
            // click nút Login
            if(type.equals("Login")){
                try {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    // Tạo 1 account vớ vẩn = builder
                    Account account=new Account.Builder(username, password).build();
                    
                    // tạo facade Login
                    LoginFacadeInterface loginFacade=new PersonLoginFacade(this, account);
                    
                    // gọi hàm Login, login thành công thì trả về 1 thằng person là mình, k thành công thì trả về null
                    Person person=loginFacade.Login();
                    
                    if (person!=null) 
                    {
                        // login thanh cong
                        LoginSucceeded(request, response, person);
                    }else{
                        // login k thanh cong
                        LoginFailed(request, response);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else{
                // chuyen sang trang dang ky
                    System.out.println("REGISTER");
                    request.getRequestDispatcher("registerPage.jsp").forward(request, response);

            }
        }
    }

    
    
    void LoginSucceeded(HttpServletRequest request, HttpServletResponse response,Person person) throws ServletException, IOException{
        
        // lay list tat ca cac loai Item ( TAM THOI LA SACH THOI)
        FetchListItem();
        
        // LAY GIO HANG CUAR THANG NGUOI DO, CHUA CO THI TAO MOI, CO ROI THI LAY LUON
        Cart userCart=PrepareCart(person);
        
        // lay các item trong gio hang
        
        
        new CartController(userCart);
        
        // CHUYEN SANG TRANG CHU
        System.out.println("FOWARD");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    void LoginFailed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("invalid.jsp").forward(request, response);
    }
    
    Cart PrepareCart(Person person){
        return cartDAO.checkCartForCustomer(person.getCustomer());
    }
    
    
    void FetchListItem(){
        // LAY LIST SACH TU DATABASE
        List<Item> listItem=itemDAO.findAll();
        System.out.println("list SIZE: "+listItem.size());
        // TAO SINGLETON QUAN LY SEARCH, CAI NAY DE LAY TAT CA CAC ITEM CHO VAO 1 CAI ITERATOR LIST 
        SearchManager searchManager=new SearchManager(listItem);
        
    }
}
