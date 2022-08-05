package com.hcl.ecommerce.Ecomerce.Controller.Product.CRUD;

import com.hcl.ecommerce.Ecomerce.Dao.ProductDao;
import com.hcl.ecommerce.Ecomerce.Model.DbCon;
import com.hcl.ecommerce.Ecomerce.Model.Product;
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
@Controller
public class EditPFormServlet extends HttpServlet {
    @Override
    @GetMapping(value = "/editP-form")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = null;
        try {
            productDao= new ProductDao(DbCon.getConnection());
            int id = Integer.parseInt(request.getParameter("id"));
            Product existingProduct = productDao.getSingleProduct(id); //double check this method untested
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProductForm.jsp"); //created later
            request.setAttribute("product", existingProduct);
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}