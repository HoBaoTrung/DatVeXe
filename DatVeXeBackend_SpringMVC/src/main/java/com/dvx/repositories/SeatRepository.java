/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.repositories;

import com.dvx.pojo.Car;
import com.dvx.pojo.Seat;
import com.dvx.pojo.Station;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ASUS
 */
public interface SeatRepository {

    public Seat getSteatsByID(long id);
//    public Set<Seat> getSeatByCar(Car car);
}
