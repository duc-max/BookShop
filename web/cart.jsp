<%-- 
    Document   : cart
    Created on : Jan 11, 2024, 4:50:59 PM
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
        <div style="background-color: bisque">
            <h1>Information of Your Cart</h1>
            <table border="1px" width="40%">
                <tr>
                    <th>Order</th>
                    <th>Product</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
                <tr>

                    <%
                    String book = (String)request.getAttribute("op");
                    int amount = (int)request.getAttribute("amount");    
                    double pricePerBook = (double)request.getAttribute("pricePerBook");    
                    double totalBill = (double)request.getAttribute("totalBill");                       
                    %>
                    <td>1</td>
                    <td><%= book %></td>
                    <td><%= amount %></td>
                    <td><%= pricePerBook %></td>
                    <td><%= totalBill %></td>
                </tr>              
            </table>
                
                <a href="book.jsp">BACK</a>

        </div>
    </body>
</html>
