package com.goods.courierapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")
public class CourierRestController {

    @GetMapping("/test")
    public String  sayHello(){
        return "Hello, World! TEST";
    }
}
