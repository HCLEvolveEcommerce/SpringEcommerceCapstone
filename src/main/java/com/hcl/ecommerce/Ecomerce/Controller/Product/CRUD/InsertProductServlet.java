package com.hcl.ecommerce.Ecomerce.Controller.Product.CRUD;

import com.hcl.ecommerce.Ecomerce.Dao.ProductDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@Controller
public class InsertProductServlet extends HttpServlet {

    @GetMapping(value = "/insert-product")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String image = request.getParameter("image");
        ProductDao productDao = null;
        try {
            double price = Double.parseDouble(request.getParameter("price")); //check back on this
            Product product = new Product(name, category , price, image);
            productDao = new ProductDao(DbCon.getConnection());
            productDao.insertProduct(product);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("ProductList.jsp");
    }

    @Override
    @PostMapping(value = "/insert-product")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}