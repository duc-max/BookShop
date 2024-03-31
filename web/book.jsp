<%-- 
    Document   : book
    Created on : Jan 11, 2024, 1:27:30 PM
    Author     : tranm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="background-color: chocolate"> 
            <h1>Welcome to Shop Book</h1>
            <form action="bookshop" method="post">
                Select Book:
                <select id="options" name="op">
                    <option>Ajax</option>
                    <option>Harry</option>
                    <option>Animals</option>
                    <option>Plants</option>
                </select>
                Amount: <input type="number" min="1" name="amount"/>
                <input type="submit" value="Buy"/>
            </form>
        </div>

       
    </body>
</html>
