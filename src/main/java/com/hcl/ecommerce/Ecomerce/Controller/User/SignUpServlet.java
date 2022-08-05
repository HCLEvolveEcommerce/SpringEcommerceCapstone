package com.hcl.ecommerce.Ecomerce.Controller.User;

import com.hcl.ecommerce.Ecomerce.Dao.UserDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@Controller
public class SignUpServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/signup-user")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        int zip = Integer.parseInt(request.getParameter("zip"));
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String lastname = request.getParameter("lastname");
        String phoneNumber = request.getParameter("phonenumber");
        UserDao udao = null;
        User user = new User(firstname, email, password, usertype, address, city, zip, state, country, lastname, phoneNumber);
        try {
            udao = new UserDao(DbCon.getConnection());
            udao.insertUser(user);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/email-signup");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
}

