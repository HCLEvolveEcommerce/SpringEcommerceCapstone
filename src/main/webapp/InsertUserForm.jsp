<%--
  Created by IntelliJ IDEA.
  User: dsike
  Date: 7/10/2022
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hcl.ecommerce.Ecomerce.Model.User" %>
<%@ page import="com.hcl.ecommerce.Ecomerce.Dao.UserDao" %>
<%@ page import="com.hcl.ecommerce.Ecomerce.Model.DbCon" %>
<%@ page import="java.util.List" %>
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
%>
<html>
<head>
  <title>Evolve</title>
  <%@include file="includes/header.jsp" %>  <!--BoostStrap CSS CDN -->
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container col-md-5">
  <div class="card">
    <div class="card-body">
      <form action="insert-user" method="post">
        <caption>
          <h2>
            Add New User
          </h2>
        </caption>
        <input type="hidden" name="id" />

        <fieldset class="form-group">
          <label>First Name</label> <input type="text"
                                          class="form-control"
                                          name="firstname" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>Last Name</label> <input type="text" minlength="5"
                                          class="form-control"
                                          name="lastname" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>User Email</label> <input type="email"
                                           class="form-control"
                                           name="email" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>Password</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="password" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>Address</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="address" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>City</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="city" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>Zip</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="zip" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>State</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="state" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>Country</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="country" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>Phone Number</label> <input type="text" minlength="5"
                                         class="form-control"
                                         name="phonenumber" required="required">
        </fieldset>

        <fieldset class="form-group">
          <label>User Type</label>
          <br>
          <select class="form-group" aria-label="Default select example" name="usertype" required="required">
            <option value='${null}'>Select User Type</option>
            <option value="Admin">Admin</option>
            <option value="Client">Client</option>
          </select>
        </fieldset>

        <button type="submit" class="btn btn-success">Save</button>
      </form>
    </div>
  </div>
</div>
<%@include file="includes/BootScript.jsp" %>
</body>
</html>