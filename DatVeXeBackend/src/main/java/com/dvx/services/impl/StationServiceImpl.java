/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Station;
import com.dvx.repositories.StationRepository;
import com.dvx.services.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Station> getStations() {
        return this.stationRepository.getStations();
    }

}
