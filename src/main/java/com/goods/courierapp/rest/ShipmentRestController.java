package com.goods.courierapp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShipmentRestController {

    @GetMapping("/shipments/create")
    public String createShipment ()
    {
        return "create-shipment";
    }
}
