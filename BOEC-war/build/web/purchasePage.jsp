<%-- 
    Document   : purchasePage
    Created on : May 6, 2018, 2:18:05 PM
    Author     : skull
--%>

<%@page import="entity.Item"%>
<%@page import="controller.CartController"%>
<%@page import="entity.CartItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>CONFIRM PURCHASE</h1>
    </body>
     <%
            List<CartItem> listItem = CartController.Instance.GetAllItem();
//           
        %>
         <table style="width:100%" border="1">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      
    </tr>
    <%
        long totalMoney=0;
        for(int i=0;i<listItem.size();i++){
            Item current=listItem.get(i).getItem();
            int id=i;
            String name=current.getName();
            float price=current.getPrice();
            long quantity=listItem.get(i).getQuantity();
            totalMoney+=price*quantity;
            
            %>
    <tr>
      <td align="center"><%=id %></td>
      <td align="center"><%=name %></td>
      <td align="center"><%=price %></td>
      <td align="center"><%=quantity %></td>
      
    </tr>
    <% } %>
</table> 

<br>
<b>SHIPPING FEE: 20000 vnd</b>
<br>
 <h1>TOTAL:  <%=totalMoney+20000%> vnd</h1>
<br>
<br>



<form action = "doPurchase" method = "post">
    <b>Select Payment Method</b><br>
    <input type="radio" name="paymentType" value="Card"> Card<br>
    <input type="radio" name="paymentType" value="Cash"> Cash<br>
    <input type = "submit" value = "Purchase Now" />
</form>
<br>
<br>
<a href="doGoToHomePage">Back To Home Page</a>
<br>
</html>
