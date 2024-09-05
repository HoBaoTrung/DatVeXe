package com.dvx.services.impl;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import com.dvx.repositories.StatsRepository;
import com.dvx.services.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class StatsServiceImpl implements  StatsService {
    @Autowired
    private StatsRepository statsRepo;

//    @Override
//    public List<Object[]> statsRevenueByProduct() {
//        return this.statsRepo.statsRevenueByProduct();
//    }

    @Override
    public List<Object[]> statsRevenueByPeriod(int year, String period) {
        return this.statsRepo.statsRevenueByPeriod(year, period);
    }
    
}