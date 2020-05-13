<%-- 
    Document   : searchPage
    Created on : May 6, 2018, 4:53:52 PM
    Author     : skull
--%>

<%@page import="java.util.List"%>
<%@page import="adapter.ItemConverter"%>
<%@page import="adapter.ItemAdapter"%>
<%@page import="entity.Item"%>
<%@page import="java.util.Iterator"%>
<%@page import="iterator.SearchManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SearchPage</h1>
    </body>
    <a href="doOpenSearchPage?index=book">Filter By Book</a>
    <a href="doOpenSearchPage?index=electronic">Filter By Electronic</a>
    <a href="doOpenSearchPage?index=clothes">Filter By Clothes</a>
    
    <br>
    <br>
     <a href="doOpenCart">View Cart</a>
    <br>
     <%
            SearchManager.Instance.Init();
            Iterator allItem=SearchManager.Instance.allItem;
        %>
     
         <table style="width:100%" border =1>
    <tr>
      <th>No.</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th> Select</th>
    </tr>
    <%
            String type=request.getParameter("index");
            
            ItemAdapter adapter=new ItemConverter();
            
                
            
            int row=1;
            while (allItem.hasNext()) 
            { 
                Item t=(Item)allItem.next();
                Item current = adapter.get(type, (Item) allItem.next()); 

                if(current==null){
                    continue;
                }

                
                int id=row++;
                String name=current.getName();
                float price=current.getPrice();
                long quantity=current.getQuantity();

            %>
    <tr>
      <td align="center" ><%=id %></td>
      <td align="center" ><%=name %></td>
      <td align="center"><%=price %></td>
      <td align="center"><%=quantity %></td>
      <td align="center">
            <a href="doCart?index=<%=current.getId()%>">Add to Cart</a>
      </td>
    </tr>
    <% } %>
</table> 

<br><br>
<h1> Search Result </h1>
<table style="width:100%" border =1>
    <tr>
      <th>No.</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th> Select</th>
    </tr>
    <%
           String searchKeyWord="all";
           try{
               searchKeyWord=request.getParameter("searchByNameInput").toString();
               
           }catch(Exception e){
               
           }
           SearchManager.Instance.Init();
            List<Item> list=SearchManager.Instance.Find(searchKeyWord);
             row=1;
            for(Item current : list)
            {
                int id=row++;
                String name=current.getName();
                float price=current.getPrice();
                long quantity=current.getQuantity();

            %>
    <tr>
      <td align="center" ><%=id %></td>
      <td align="center" ><%=name %></td>
      <td align="center"><%=price %></td>
      <td align="center"><%=quantity %></td>
      <td align="center">
            <a href="doCart?index=<%=current.getId()%>">Add to Cart</a>
      </td>
    </tr>
    <% } %>
</table> 
<br>
<br>
<a href="doGoToHomePage">Back To Home Page</a>
</html>
