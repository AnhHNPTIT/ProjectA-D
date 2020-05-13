<%-- 
    Document   : registerPage
    Created on : May 5, 2018, 1:53:47 PM
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
        <h1>REGISTER!</h1>
         <form action="RegisterServlet" method="post">
           Username <input type="text" name="username" value="" /><br/>
           Password <input type="password" name="password" value="" /><br/>
           Name <input type="text" name="name" value="" /><br/>
           LastName <input type="text" name="lastname" value="" /><br/>
           BirthDay <input type="date" name="birthday" value="" /><br/>
           PhoneNumber <input type="text" name="phonenumber" value="" /><br/>
           Email <input type="text" name="email" value="" /><br/>
           Gender <input type="text" name="gender" value="" /><br/>
           ID <input type="text" name="identifynumber" value="" /><br/>
           Number <input type="text" name="number" value="" /><br/>
           Street <input type="text" name="street" value="" /><br/>
           District <input type="text" name="district" value="" /><br/>
           City <input type="text" name="city" value="" /><br/>
           Country <input type="text" name="country" value="" /><br/>

            <input type="submit" name="RegisterBtn" value="Register" />
        </form>
    </body>
</html>

