package com.uv.parkingcity.data.dao.daointerface;

import com.uv.parkingcity.data.entities.Ticket;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface TicketDao {

    int addTicket(Ticket ticket) throws SQLException;
    ArrayList<Ticket> getAllTicketsByEntryDate(LocalDate entryDate) throws SQLException;
    Ticket getTicketByParkingSpaceId (int id) throws SQLException;

}
