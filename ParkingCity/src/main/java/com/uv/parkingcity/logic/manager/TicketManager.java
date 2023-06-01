package com.uv.parkingcity.logic.manager;

import com.uv.parkingcity.data.dao.daoimplement.TicketDaoImp;
import com.uv.parkingcity.data.entities.Ticket;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TicketManager {

    TicketDaoImp ticketDaoImp = new TicketDaoImp();

    public int addTicket(Ticket ticket) throws SQLException {
        return ticketDaoImp.addTicket(ticket);
    }

    ArrayList<Ticket> getAllTicketsByEntryDate(LocalDate entryDate) throws SQLException {
        return ticketDaoImp.getAllTicketsByEntryDate(entryDate);
    }

}
