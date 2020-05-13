<%@page import="java.util.Iterator"%>
<%@page import="iterator.SearchManager"%>
<%@page import="iterator.AllItemIterator"%>
<%@page import="java.util.List"%>
<%@page import="entity.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
    </head>
    <body>
        <h1>HOME PAGE</h1>
    </body>
    <a href="doOpenCart">View Cart</a>
    <!--<a href="doOpenSearchPage?index=book">Search</a>-->
    <form action = "doOpenSearchPage?index=book" method = "post">
          <b>Search by name  </b> <input type="text" name="searchByNameInput" value=""> <br>
          <input type="Submit" name="SearchBtn" value="Search" >
    </form> 
   
    <br>
     <%
            SearchManager.Instance.Init();
            Iterator allItem=SearchManager.Instance.allItem;
        %>
     
         <table style="width:100%" border="1">
    <tr>
      <th>No.</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th> Select</th>
    </tr>
    <%
            int row=1;
            while (allItem.hasNext()) 
            { 
                Item current = (Item) allItem.next(); 
                
                int id=row++;
                String name=current.getName();
                float price=current.getPrice();
                long quantity=current.getQuantity();

            %>
    <tr>
      <td align="center"><%=id %></td>
      <td align="center"><%=name %></td>
      <td align="center"><%=price %></td>
      <td align="center"><%=quantity %></td>
      <td align="center">
          <a href="doCart?index=<%=current.getId() %>">Add to Cart</a>
      </td>
    </tr>
    <% } %>
</table> 
</html>
