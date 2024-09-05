/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.repositories;

import com.dvx.pojo.Orders;
import com.dvx.pojo.Ticket;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public interface TicketRepository {
    public Ticket getById(long id);
     public List<Ticket> getByOrder(Orders id);
    boolean deleteTicket(long id);
    boolean addOrUpdateTicket(Ticket u);
}
