<%-- 
    Document   : index
    Created on : May 5, 2018, 1:34:42 PM
    Author     : skull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome home!</h1>
        <font color="red" size="6">
        Att: ${requestScope.username}<br/>
        Ses: ${sessionScope.user}
        <%
            
            
            
            request.getRequestDispatcher("homePage.jsp").forward(request, response);

            %>
        </font>
    </body>
</html>