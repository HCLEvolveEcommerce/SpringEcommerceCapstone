package com.hcl.ecommerce.Ecomerce.Controller.User.CRUD;

import com.hcl.ecommerce.Ecomerce.Dao.UserDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
@Controller
public class EditUFormServlet extends HttpServlet {
    private UserDao userDao;
    private User user;
    User existingUser;
    public EditUFormServlet(UserDao uDao, User user) {
        userDao = uDao;
        this.user = user;
    }
    public EditUFormServlet() {
        user = new User();
    }

    @Override
    @GetMapping(value = "/editU-form")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (user != null) {
                request.getSession().setAttribute("auth", user);
                    if (Objects.equals(user.getUsertype(), "Admin")) {
                        userDao = new UserDao(DbCon.getConnection());
                        int id = Integer.parseInt(request.getParameter("id"));
                        existingUser = userDao.selectUser(id);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateUserForm.jsp"); //created later
                        request.setAttribute("user", existingUser);
                        dispatcher.forward(request, response);
                    } else {
                        userDao = new UserDao(DbCon.getConnection());
                        int id = Integer.parseInt(request.getParameter("id"));
                        existingUser = userDao.selectUser(id);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientUpdateForm.jsp"); //created later
                        request.setAttribute("user", existingUser);
                        dispatcher.forward(request, response);
                    }
                }

            } catch(ClassNotFoundException | SQLException e){
                throw new RuntimeException(e);
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
