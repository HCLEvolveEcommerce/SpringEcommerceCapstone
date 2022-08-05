package com.hcl.ecommerce.Ecomerce.Controller.Order;

import com.hcl.ecommerce.Ecomerce.Dao.OrderDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@Controller
public class RemoveOrderServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/remove-order")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDao orderdao = null;
        try {
            orderdao = new OrderDao(DbCon.getConnection());
            int id = Integer.parseInt(request.getParameter("id"));
            orderdao.deleteOrders(id); //code this
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("AccountPage.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
