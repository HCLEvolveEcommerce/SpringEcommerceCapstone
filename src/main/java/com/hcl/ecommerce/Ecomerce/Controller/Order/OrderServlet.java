package com.hcl.ecommerce.Ecomerce.Controller.Order;

import com.hcl.ecommerce.Ecomerce.Dao.OrderDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.Order;
import com.hcl.ecommerce.Ecomerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
public class OrderServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/user-order")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try{
            User auth = (User) session.getAttribute("auth"); //play with this //maye have to revert back to request.getSession.get
            if (auth != null) {
                String prodId= request.getParameter("id");
                int prodQuant= Integer.parseInt(request.getParameter("quantity"));

                if (prodQuant <=0 ){
                    prodQuant = 1; //check this logic
                }

                Order order = new Order();
                order.setId(Integer.parseInt(prodId));
                order.setUserID(auth.getId());
                order.setQuantity(prodQuant);
                order.setOrderDate(formatter.format(date));

                OrderDao orderDao = new OrderDao(DbCon.getConnection());
                orderDao.insertOrder(order);
                response.sendRedirect("AccountPage.jsp");



            }else{
                String prodId= request.getParameter("id");
                int prodQuant= Integer.parseInt(request.getParameter("quantity"));
                if (prodQuant <=0 ){
                    prodQuant = 1; //check this logic
                }
                    Order order = new Order();
                    order.setId(Integer.parseInt(prodId));
                    order.setUserID(0);
                    order.setQuantity(prodQuant);
                    order.setOrderDate(formatter.format(date));

                    OrderDao orderDao = new OrderDao(DbCon.getConnection());
                    orderDao.insertOrder(order);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
