package com.goods.courierapp.service;

import com.goods.courierapp.models.Pilot;
import com.goods.courierapp.models.Shipment;

public interface ShipmentService {

    Shipment save (Shipment theShipment);

    void deleteById(int theId);
    Shipment findById(int shipmentId);
}
