package com.goods.courierapp.service;

import com.goods.courierapp.models.Pilot;

public interface PilotService {

    Pilot save (Pilot thePilot);

    void deleteById (int theId);

    Pilot findById(int pilotId);

    Pilot findByUsername(String username);
}
