<%-- 
    Document   : cartPage
    Created on : May 5, 2018, 7:44:54 PM
    Author     : skull
--%>

<%@page import="entity.CartItem"%>
<%@page import="controller.CartController"%>
<%@page import="entity.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>YOUR CART</h1>
    </body>
     <%
            List<CartItem> listItem = CartController.Instance.GetAllItem();
//           
        %>
         <table style="width:100%" border =1>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th> Select</th>
    </tr>
    <%
        for(int i=0;i<listItem.size();i++){
            Item current=listItem.get(i).getItem();
            int id=i;
            String name=current.getName();
            float price=current.getPrice();
            long quantity=listItem.get(i).getQuantity();
            
            %>
    <tr>
      <td align="center"><%=id %></td>
      <td align="center"><%=name %></td>
      <td align="center"><%=price %></td>
      <td align="center" ><%=quantity %></td>
      <td align="center">
            <a href="doRemoveItemFromCart?index=<%=i%>">Remove</a>
      </td>
    </tr>
    <% } %>
</table> 
<a href="doGoToPurchasePage">Purchase</a>

<br>
<br>

<br>
<br>
<a href="doGoToHomePage">Back To Home Page</a>
</html>
