package com.hcl.ecommerce.Ecomerce.Controller.SpringTest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @PostMapping(value = "/get")
    public String controller(){
        return "Controller.jsp";
    }
}
//herllo