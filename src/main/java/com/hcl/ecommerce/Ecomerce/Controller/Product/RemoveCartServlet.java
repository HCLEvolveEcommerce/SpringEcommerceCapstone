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
import java.util.ConcurrentModificationException;
@Controller
public class RemoveCartServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/remove-cart")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            int id = Integer.parseInt(request.getParameter("id"));
            Cart cart = new Cart();
            cart.setId(id);
            String action = request.getParameter("action");
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            if (action != null) {
                for (Cart c : cart_list) {
                    for (Cart a : cartList) {
                        if (a.getId() == id) {
                            cartList.remove(a);
                            response.sendRedirect("ShoppingCart.jsp");
                        }

                    }
                }
            }
        } catch (ConcurrentModificationException exception) {
            // Catch ConcurrentModificationExceptions.
        }
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
