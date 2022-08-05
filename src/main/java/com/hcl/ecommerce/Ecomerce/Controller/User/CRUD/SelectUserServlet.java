package com.hcl.ecommerce.Ecomerce.Controller.User.CRUD;

import com.hcl.ecommerce.Ecomerce.Dao.UserDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@Controller
public class SelectUserServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/select-user")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User();
        UserDao userDao = null;
        try (PrintWriter out = response.getWriter()){
            userDao = new UserDao(DbCon.getConnection());
            userDao.selectUser(id);
            System.out.println(request.getParameter("id"));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}

//Alex was here
