<%@page import="entity.*"%> 
<%@page import="java.util.List"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Item list = (Item) session.getAttribute("listBook");
            out.print(list.getName());
        %>
    </body>
</html>
