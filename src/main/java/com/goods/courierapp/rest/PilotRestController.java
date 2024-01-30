package com.goods.courierapp.rest;

import com.goods.courierapp.models.Customer;
import com.goods.courierapp.models.Pilot;
import com.goods.courierapp.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class PilotRestController {

    private PilotService pilotService;

    @Autowired
    public PilotRestController(PilotService thePilotService) {
        this.pilotService = thePilotService;
    }

    @GetMapping("/pilots/test")
    public String test ()
    {
        return " I am testing apis from pilots";
    }

    @GetMapping("/pilots/{pilotId}")
    public Pilot getPilotById (@PathVariable int pilotId)
    {
        Pilot thePilot = pilotService.findById(pilotId);

        if( thePilot == null)
            throw new RuntimeException("Pilot with id: "+pilotId+" not found!");

        return thePilot;
    }

    @GetMapping("/pilots/username/{username}")
    public Pilot getPilotByUsername (@PathVariable String username)
    {
        Pilot thePilot = pilotService.findByUsername(username);

        if( thePilot == null)
            throw new RuntimeException("Pilot with username: "+username+" not found!");

        return thePilot;
    }

    @PostMapping("/pilots")
    public Pilot addPilot (@RequestBody Pilot thePilot)
    {
        Pilot dbPilot = pilotService.save(thePilot);

        return dbPilot;
    }

    @DeleteMapping("/pilots/{pilotId}")
    public String deletePilot(@PathVariable int pilotId)
    {

        Pilot thePilot = pilotService.findById(pilotId);

        if(thePilot == null)
            throw  new RuntimeException("This pilot doesn't exist!!");

        pilotService.deleteById(pilotId);

        return "Deleted Pilot with Id: " + pilotId;
    }
}
