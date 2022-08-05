package com.hcl.ecommerce.Ecomerce.Controller.Product;

import com.hcl.ecommerce.Ecomerce.Model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@Controller
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @GetMapping(value = "/add-cart")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            ArrayList<Cart> cartList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Cart cart = new Cart();
            cart.setId(id);
            cart.setQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            if (cart_list == null) {
                cartList.add(cart);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            }
                else {
                cartList = cart_list;

                boolean exist = false;
                for (Cart c : cart_list) {
                    if (c.getId() == id) {
                        exist = true;
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        response.sendRedirect("index.jsp");
                    }
                }

                if (!exist) {
                    cartList.add(cart);
                    response.sendRedirect("index.jsp");

                }
            }
        }
    }

}

