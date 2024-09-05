/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.Role;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface RoleService {
    public Role getRoleByName(String name);
     public List<Role> getAllRole() ;
}
