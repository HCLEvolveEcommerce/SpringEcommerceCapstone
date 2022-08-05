package com.hcl.ecommerce.Ecomerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomePage {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
//    @RequestMapping("index")
//    public String handleFoo() {
//        return "welcome.jsp";
//    }
}
