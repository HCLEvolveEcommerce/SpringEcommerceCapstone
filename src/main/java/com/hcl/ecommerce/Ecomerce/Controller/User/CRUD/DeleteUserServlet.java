package com.hcl.ecommerce.Ecomerce.Controller.User.CRUD;

import com.hcl.ecommerce.Ecomerce.Dao.UserDao;
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
public class DeleteUserServlet extends HttpServlet {
    UserDao udao;
    boolean isDeleted;
    public DeleteUserServlet() {
        udao = null;
    }
    public DeleteUserServlet(UserDao udao) {
        this.udao = udao;
    }
    @Override
    @GetMapping(value = "/delete-user")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            udao = new UserDao(DbCon.getConnection());
            int id = Integer.parseInt(request.getParameter("id"));
            isDeleted = udao.deleteUser(id);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("UserList.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
