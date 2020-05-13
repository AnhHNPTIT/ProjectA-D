<%-- 
    Document   : login
    Created on : May 5, 2018, 1:35:01 PM
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
        <h1>Login!</h1>
         <form action="LoginServlet" method="post">
           Username <input type="text" name="username" value="" /><br/>
           Password <input type="password" name="password" value="" /><br/>
            <input type="submit" name="Btn" value="Login" />
            <input type="submit" name="Btn" value="Register" />
        </form>
    </body>
</html>
