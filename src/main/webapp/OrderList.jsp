<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dsike
  Date: 7/10/2022
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hcl.ecommerce.Ecomerce.Dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hcl.ecommerce.Ecomerce.Dao.OrderDao" %>
<%@ page import="com.hcl.ecommerce.Ecomerce.Model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    User admin = (User) request.getSession().getAttribute("admin");
    if(admin!= null){
        request.setAttribute("admin", admin);
    }

    UserDao ud = new UserDao(DbCon.getConnection());
    List<User> users = ud.getAllUsers();

    OrderDao od = new OrderDao(DbCon.getConnection());
    List<Order> orders = od.getAllOrders();
%>
<html>
<head>
    <title>Evolve</title>
    <%@include file="includes/header.jsp" %>  <!--BoostStrap CSS CDN -->
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
    <div class="container">
        <br>
        <br>
        <h3 class="text-center">List of Orders</h3>
        <hr>
        <div class="container text-center">
            <a href="InsertUserForm.jsp" class="btn btn-success" id="adminButton">Add
                New User</a>
            <a href="ProductList.jsp" class="btn btn-success" id="adminButton2">Products Table</a>
        </div>
        <br>

        <!--Search User -->
<%--        <nav class="navbar bg-light text-center">--%>
<%--            <form action="select-user" class="container-fluid" method="get">--%>
<%--                <div class="input-group">--%>
<%--                    <span class="input-group-text" id="basic-addon1">@</span>--%>
<%--                    <input type="text" name="id" class="form-control" placeholder="email or id" value="search" aria-label="Username" aria-describedby="basic-addon1">--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </nav>--%>

        <table class="table table-bordered" id="table" style="border-width: thick ">
            <thead style="border-width: thick;">
            <tr>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>User ID</th>
                <th>Order Date</th>
                <th>Order Quantity</th>
            </tr>
            </thead>
            <%if (!orders.isEmpty()){
                for(Order o:orders){%>
            <tbody>
            <tr>
                <td><%=o.getOrderID()%></td>
                <td><%=o.getId()%></td>
                <td><%=o.getUserID()%></td>
                <td><%=o.getOrderDate()%></td>
                <td><%=o.getQuantity()%></td>
            </tr>
            </tbody>
            <%}
            }%>

        </table>

    </div>
    <%@include file="includes/BootScript.jsp" %>
</body>
</html>
