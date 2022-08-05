package com.hcl.ecommerce.Ecomerce.Controller.Order;

import com.hcl.ecommerce.Ecomerce.Dao.OrderDao;
import com.hcl.ecommerce.Ecomerce.Model.Cart;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.Order;
import com.hcl.ecommerce.Ecomerce.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
@Controller
public class OrderAllServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/order-all")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date();
            ArrayList<Cart> cart_list = (ArrayList<Cart>)  request.getSession().getAttribute("cart-list");
            User auth = (User) session.getAttribute("auth");
            Order order = new Order();

            if (cart_list != null) {
                if (auth != null){
                    for (Cart c: cart_list){

                        order.setId(c.getId());
                        order.setUserID(auth.getId());
                        order.setQuantity(c.getQuantity());
                        order.setOrderDate(formatter.format(date));
                        order.setPrice(c.getPrice());

                        OrderDao orderDao = new OrderDao(DbCon.getConnection());
                        orderDao.insertOrder(order);
                        response.sendRedirect("AccountPage.jsp");

                    }

                }
                else {
                    for (Cart c: cart_list){
                        order.setId(c.getId());
                        order.setUserID(0);
                        order.setQuantity(c.getQuantity());
                        order.setOrderDate(formatter.format(date));
                        OrderDao orderDao = new OrderDao(DbCon.getConnection());
                        orderDao.insertOrder(order);
                        response.sendRedirect("index.jsp");
                    }

                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
