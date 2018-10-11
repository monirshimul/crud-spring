<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product All</title>
        <script src="angular.min.js"></script>
        <style>
            table, th ,td{
                
                border: 1px solid grey;
                border-collapse: collapse;
                padding: 5px;
                
            }
            table tr:nth-child(odd){
                
                background-color: #ffffff;
            }
            table tr:nth-child(even){
                background-color: #999999;
            }
        </style>
    </head>

    <body>
        <a href="newadd.htm">Add new Product</a><br>
        <div ng-app="myApp" ng-controller="productCtrl">
            <table style="border-collapse: collapse" cellpadding="5px" border="1">
                <tr>
                    <td>Serial</td>
                    <td>Product Id</td>
                    <td>Product Name</td>
                    <td>Product Price</td>
                    <td>Product Quantity</td>
                    <td>Product Description</td>
                    <td>Action</td>
                </tr>
                <c:forEach items="${list}" var="p">
                    <tr>
                        <td>${index+1}</td>
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.price}</td>
                        <td>${p.quantity}</td>
                        <td>${p.description}</td>
                        
                        <td>
                            <a href="edit.htm?id=${p.productId}">Edit</a>|
                            <a href="remove.htm?id=${p.productId}" onclick="return confirm('Are you sure')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
