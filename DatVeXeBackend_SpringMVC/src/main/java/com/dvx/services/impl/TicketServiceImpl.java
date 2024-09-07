/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.services.impl;

import com.dvx.pojo.Orders;
import com.dvx.pojo.Ticket;
import com.dvx.pojo.Trip;
import com.dvx.repositories.TicketRepository;
import com.dvx.services.TicketService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket getById(long id) {
        return this.ticketRepository.getById(id);
    }
    
    @Override
    public void updatePaymentTicket(Long orderId, Date paymentDate){
    ticketRepository.updatePaymentTicket(orderId, paymentDate);
    }

    @Override
    public boolean deleteTicket(long id) {
        return this.ticketRepository.deleteTicket(id);
    }

    @Override
    public boolean addOrUpdateTicket(Ticket u) {
        return this.ticketRepository.addOrUpdateTicket(u);
    }

    @Override
    public List<Ticket> getByOrder(Orders o) {
        return this.ticketRepository.getByOrder(o);
    }
    

}
