package com.goods.courierapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierRestController {

    public CourierRestController() {

    }

    @GetMapping("/")
    public String  sayHello(){
        return "Hello, World!";
    }
}
