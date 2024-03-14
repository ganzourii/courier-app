package com.goods.courierapp.dao;

import com.goods.courierapp.models.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment,Integer> {
}
