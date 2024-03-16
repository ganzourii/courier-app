package com.goods.courierapp.service;

import com.goods.courierapp.dao.ShipmentRepository;
import com.goods.courierapp.models.Pilot;
import com.goods.courierapp.models.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService{


    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) { this.shipmentRepository = shipmentRepository; }

    @Override
    public Shipment save(Shipment theShipment) {
        return shipmentRepository.save(theShipment) ;
    }

    @Override
    public void deleteById(int theId) {
        shipmentRepository.deleteById(theId);
    }

    @Override
    public Shipment findById(int shipmentId) {
        Optional<Shipment> result = shipmentRepository.findById(shipmentId);
        Shipment theShipment = null;
        if(result.isPresent())
        {
            theShipment = result.get();
        }
        else
        {
            throw new RuntimeException("There's no shipment with Id: " + shipmentId );
        }
        return theShipment;
    }
}
