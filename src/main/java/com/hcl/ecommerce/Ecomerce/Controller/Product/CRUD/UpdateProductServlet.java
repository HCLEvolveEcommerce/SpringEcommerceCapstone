package com.hcl.ecommerce.Ecomerce.Controller.Product.CRUD;

import com.hcl.ecommerce.Ecomerce.Dao.ProductDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@Controller
public class UpdateProductServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/update-product")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Am I touched");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("post parse");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        Double price = Double.valueOf(request.getParameter("price")); //idk about this
        String image = request.getParameter("image");
        ProductDao productDao = null;
        Product product = new Product(id, name, category, price, image);
        System.out.println("before try");

        try {
            productDao = new ProductDao(DbCon.getConnection());
            productDao.updateProduct(product);
            System.out.println("after try");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("after catch");
        response.sendRedirect("ProductList.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
