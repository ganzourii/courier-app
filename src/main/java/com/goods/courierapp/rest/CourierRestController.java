package com.goods.courierapp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CourierRestController {
    @GetMapping
    public String sayHello(){
        return "home";
    }
}
