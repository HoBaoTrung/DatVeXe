/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.Types;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TypesService {

    public Types getTypeByName(String name);
    public List<Types> getAllType();
    public boolean addOrUpdate(Types t);
    public boolean deleteType(long id);
    public Types getTypeById(Long id);
}
