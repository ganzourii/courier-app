package com.goods.courierapp.service;

import com.goods.courierapp.dao.PilotRepository;
import com.goods.courierapp.models.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService{

    private PilotRepository pilotRepository;

    @Autowired
    public PilotServiceImpl(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    public Pilot save(Pilot thePilot){

        return pilotRepository.save(thePilot);
    }

    public void deleteById(int theId){
        pilotRepository.deleteById(theId);
    }
    @Override
    public Pilot findById(int pilotId) {

        Optional<Pilot> result = pilotRepository.findById(pilotId);
        Pilot thePilot = null;
        if(result.isPresent())
        {
            thePilot = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find pilot id: " + pilotId );
        }
        return thePilot;
    }

    @Override
    public Pilot findByUsername(String username)
    {
        Optional<Pilot> result = pilotRepository.findByUsername(username);
        Pilot thePilot = null;
        if(result.isPresent())
        {
            thePilot = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find pilot username: " + username );
        }
        return thePilot;
    }

}
