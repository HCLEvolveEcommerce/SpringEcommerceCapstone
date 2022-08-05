package com.hcl.ecommerce.Ecomerce.Controller.User;

import com.hcl.ecommerce.Ecomerce.Dao.UserDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@Controller
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PostMapping(value = "/user-login")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        try {
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");

            UserDao udao = new UserDao(DbCon.getConnection());
            User user = udao.userLogin(email, password);
            if (user != null) {
                request.getSession().setAttribute("auth", user);
                if(Objects.equals(user.getUsertype(), "Admin")) {
                    request.getSession().setAttribute("admin", user);
                    session.setAttribute("id", user.getId());
                    session.setAttribute("firstname", user.getFirstname());
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("usertype", user.getUsertype());
                    session.setAttribute("address", user.getAddress());
                    session.setAttribute("city", user.getCity());
                    session.setAttribute("zip", user.getZip());
                    session.setAttribute("state", user.getState());
                    session.setAttribute("country", user.getCountry());
                    session.setAttribute("lastname", user.getLastname());
                    session.setAttribute("phonenumber", user.getPhonenumber());

                    response.sendRedirect("UserList.jsp");
                    System.out.println("Logged in as Admin");
                    System.out.println(session.getAttribute("email") + " " + session.getAttribute("usertype"));
                }
                
                else {
                    session.setAttribute("id", user.getId());
                    session.setAttribute("firstname", user.getFirstname());
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("usertype", user.getUsertype());
                    session.setAttribute("address", user.getAddress());
                    session.setAttribute("city", user.getCity());
                    session.setAttribute("zip", user.getZip());
                    session.setAttribute("state", user.getState());
                    session.setAttribute("country", user.getCountry());
                    session.setAttribute("lastname", user.getLastname());
                    session.setAttribute("phonenumber", user.getPhonenumber());
                    response.sendRedirect("index.jsp");
                    System.out.println("Logged in as User");
                    System.out.println(session.getAttribute("email") + " " + session.getAttribute("usertype"));

                }
            } else {
                response.sendRedirect("login.jsp");
                String invalid = "Invalid Login, Please Try Again.";
                request.getSession().setAttribute("invalid", invalid);
                System.out.println(session.getId());

            }
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
}
