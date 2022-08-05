package com.hcl.ecommerce.Ecomerce.Controller.Product;

import com.hcl.ecommerce.Ecomerce.Model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@Controller
public class QuantityContServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/quantity-control")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try{
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));

            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            if (action != null && id >= 1){
                if(action.equals("inc")){
                    for (Cart c:cart_list){
                        if(c.getId() == id){
                            int quantity = c.getQuantity();
                            quantity++;
                            c.setQuantity(quantity);
                            response.sendRedirect("ShoppingCart.jsp");
                        }
                    }
                }
                if(action.equals("dec")){
                    for (Cart c:cart_list){
                        if(c.getId() == id){
                            int quantity = c.getQuantity();
                            quantity--;
                            c.setQuantity(quantity);
                            response.sendRedirect("ShoppingCart.jsp");
                        }
                    }
                }
            }
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
