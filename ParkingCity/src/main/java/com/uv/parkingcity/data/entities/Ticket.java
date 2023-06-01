package com.uv.parkingcity.data.entities;

import com.uv.parkingcity.data.entities.enums.TicketStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {

    private int ticketId;
    private LocalTime entryTime;
    private LocalDate entryDate;
    private LocalDate departureDate;
    private LocalTime departureTime;

    private TicketStatus ticketStatus;
    private ParkingSpace parkingSpace;

    public Ticket() {
    }

    public Ticket(int ticketId, LocalTime entryTime, LocalDate entryDate, LocalDate departureDate,
                  LocalTime departureTime, TicketStatus ticketStatus, ParkingSpace parkingSpace) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.ticketStatus = ticketStatus;
        this.parkingSpace = parkingSpace;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}
