/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Types;
import com.dvx.pojo.TypesSeat;
import com.dvx.repositories.TypeRepository;
import com.dvx.repositories.TypeSeatRepository;
import com.dvx.services.TypesSeatService;
import com.dvx.services.TypesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TypesSeatServiceImpl implements TypesSeatService {

    @Autowired
    private TypeSeatRepository typeSeatRepo;


    @Override
    public List<TypesSeat> getAllTypeSeat(){
   return this.typeSeatRepo.getAllTypeSeat();}
    


}
