<%-- 
    Document   : add
    Created on : Jan 25, 2018, 4:27:55 PM
    Author     : Round-32
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Form</h1>
        <form:form action="add.htm" modelAttribute="product">
            <table style="align-content: center" cellpadding="5px">
                <tr>
                    
                    <td>Product Name</td>
                    <td>Product Price</td>
                    <td>Product Quantity</td>
                    <td>Product Description</td>
                </tr>
               
                    <tr>
                        <td><input type="text" name="productName"/></td>
                        <td><input type="text" name="price"/></td>
                        <td><input type="text" name="quantity"/></td>
                        <td><input type="text" name="description"/></td>
                        <td><input type="submit"/></td>
                        
                    </tr>
                
            </table>
        </form:form>
    </body>
</html>
