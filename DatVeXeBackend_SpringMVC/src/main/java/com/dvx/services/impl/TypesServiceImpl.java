/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Types;
import com.dvx.repositories.TypeRepository;
import com.dvx.services.TypesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    private TypeRepository typeRepo;

    @Override
    public Types getTypeByName(String name) {
        return this.typeRepo.getTypeByName(name);
    }

    @Override
    public List<Types> getAllType() {
        return this.typeRepo.getAllType();
    }

    @Override
    public Types getTypeById(Long id) {
        return this.typeRepo.getTypeById(id);
     }

    @Override
    public boolean addOrUpdate(Types t) {
  return this.typeRepo.addOrUpdate(t);}

    @Override
    public boolean deleteType(long id) {
   return this.typeRepo.deleteType(id);  }

}
