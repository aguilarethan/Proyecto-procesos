package com.uv.parkingcity.data.dao.daoimplement;

import com.uv.parkingcity.data.dao.daointerface.TicketDao;
import com.uv.parkingcity.data.database.Database;
import com.uv.parkingcity.data.entities.ParkingSpace;
import com.uv.parkingcity.data.entities.Ticket;
import com.uv.parkingcity.data.entities.enums.TicketStatus;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TicketDaoImp implements TicketDao {

    Database database = new Database();

    @Override
    public int addTicket(Ticket ticket) throws SQLException {
        int result = 0;

        String query = "INSERT INTO Ticket (HoraEntrada, FechaEntrada, Estado, CajonEstacionamientoID) VALUES" +
                "(?, ?, ?, ?)";

        Connection connection = database.getConnection();
        PreparedStatement addTicketStatement = connection.prepareStatement(query);

        addTicketStatement.setString(1, String.valueOf(ticket.getEntryTime()));
        addTicketStatement.setString(2, String.valueOf(ticket.getEntryDate()));
        addTicketStatement.setString(3, String.valueOf(ticket.getTicketStatus()));
        addTicketStatement.setInt(4, ticket.getParkingSpace().getParkingSpaceId());

        result = addTicketStatement.executeUpdate();
        connection.close();

        return result;
    }

    @Override
    public ArrayList<Ticket> getAllTicketsByEntryDate(LocalDate entryDate) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Ticket WHERE FechaEntrada = ?";

        Connection connection = database.getConnection();
        PreparedStatement getTicketsStatement = connection.prepareStatement(query);
        getTicketsStatement.setDate(1, Date.valueOf(entryDate));
        ResultSet resultSet = getTicketsStatement.executeQuery();

        while (resultSet.next()) {
            int ticketId = resultSet.getInt("TicketID");
            LocalTime entryTime = resultSet.getTime("HoraEntrada").toLocalTime();
            LocalDate recoverEntryDate = resultSet.getDate("FechaEntrada").toLocalDate();
            LocalDate departureDate = resultSet.getDate("FechaSalida").toLocalDate();
            LocalTime departureTime = resultSet.getTime("HoraSalida").toLocalTime();
            TicketStatus status = TicketStatus.valueOf(resultSet.getString("Estado"));
            int parkingSpaceId = resultSet.getInt("CajonEstacionamientoID");

            ParkingSpaceDaoImp parkingSpaceDaoImp = new ParkingSpaceDaoImp();
            ParkingSpace parkingSpace = parkingSpaceDaoImp.getParkingSpaceById(parkingSpaceId);

            Ticket ticket = new Ticket(ticketId, entryTime, recoverEntryDate, departureDate, departureTime, status, parkingSpace);


        }

        resultSet.close();
        getTicketsStatement.close();
        connection.close();

        return tickets;
    }

    @Override
    public Ticket getTicketByParkingSpaceId(int id) throws SQLException {
        String query = "SELECT * FROM Ticket WHERE CajonEstacionamientoID = ? AND Estado = 'SIN_PAGAR'";
        Ticket ticket = new Ticket();

        Connection connection = database.getConnection();
        PreparedStatement getTicketStatement = connection.prepareStatement(query);
        getTicketStatement.setInt(1, id);
        ResultSet resultSet = getTicketStatement.executeQuery();

        while (resultSet.next()) {
            int ticketId = resultSet.getInt("TicketID");
            LocalTime entryTime = resultSet.getTime("HoraEntrada").toLocalTime();
            LocalDate recoverEntryDate = resultSet.getDate("FechaEntrada").toLocalDate();
            LocalDate departureDate = resultSet.getDate("FechaSalida").toLocalDate();
            LocalTime departureTime = resultSet.getTime("HoraSalida").toLocalTime();
            TicketStatus status = TicketStatus.valueOf(resultSet.getString("Estado"));
            int parkingSpaceId = resultSet.getInt("CajonEstacionamientoID");

            ParkingSpaceDaoImp parkingSpaceDaoImp = new ParkingSpaceDaoImp();
            ParkingSpace parkingSpace = parkingSpaceDaoImp.getParkingSpaceById(parkingSpaceId);

            ticket = new Ticket(ticketId, entryTime, recoverEntryDate, departureDate, departureTime, status, parkingSpace);


        }

        resultSet.close();
        getTicketStatement.close();
        connection.close();

        return ticket;
    }


}
