package com.dvx.services;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.List;

/**
 *
 * @author admin
 */
public interface StatsService {
//    List<Object[]> statsRevenueByProduct();
    List<Object[]> statsRevenueByPeriod(int year, String period);
}