package com.goods.courierapp.rest;

import com.goods.courierapp.models.Pilot;
import com.goods.courierapp.models.Shipment;
import com.goods.courierapp.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shipments")
public class ShipmentRestController {

    private ShipmentService shipmentService;

    @Autowired
    public ShipmentRestController(ShipmentService theShipmentService) { this.shipmentService = theShipmentService;}

    @GetMapping("/create")
    public String createShipment ()
    {
        return "create-shipment";
    }

    @GetMapping("/{trackNumber}")
    public String getShipmentById (@RequestParam("trackNumber") int trackNumber, Model theModel)
    {
/*
        Shipment theShipment = shipmentService.findById(trackNumber);

        if(theShipment == null)
        {
            throw new RuntimeException(" There's no shipment with this Id: "+trackNumber );
        }
        else
        {
            theModel.addAttribute("shipment", theShipment);
        }
*/

        return "shipment-status";
    }
}
