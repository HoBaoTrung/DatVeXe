/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.repositories;

import com.dvx.pojo.Types;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TypeRepository {
    public List<Types> getAllType();
    public Types getTypeByName(String name);
    public Types getTypeById(Long id);
    public boolean addOrUpdate(Types t);
    public boolean deleteType(long id);
}
