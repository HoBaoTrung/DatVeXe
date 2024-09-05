/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dvx.services;

import com.dvx.pojo.Orders;
import com.dvx.pojo.Ticket;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TicketService {

    public Ticket getById(long id);
    public List<Ticket> getByOrder(Orders o);
    boolean deleteTicket(long id);

    boolean addOrUpdateTicket(Ticket u);
}
