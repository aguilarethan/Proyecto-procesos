package com.uv.parkingcity.view;

import com.uv.parkingcity.data.entities.Ticket;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TicketItemController implements Initializable {

    public Label lbl_EntryDate;
    public Label lbl_EntryTime;
    public Label lbl_TicketStatus;
    public Label lbl_ParkingSpace;
    public Button btn_Select;
    public Label lbl_DepartureTime;
    public Label lbl_DepartureDate;
    Ticket ticket = new Ticket();
    PayTicketController payTicketController = new PayTicketController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_Select.setOnAction(event -> {
            payTicketController.calculateTotal(ticket);
        });
    }

    public void setTicketData (Ticket ticket, PayTicketController payTicketController) throws SQLException {
        this.payTicketController = payTicketController;
        this.ticket = ticket;
        lbl_EntryDate.setText("Fecha de entrada: " + String.valueOf(ticket.getEntryDate()));
        lbl_EntryTime.setText("Hora de entrada: " + String.valueOf(ticket.getEntryTime()));
        lbl_TicketStatus.setText("Estado: " + String.valueOf(ticket.getTicketStatus()).replace("_", " "));
        lbl_ParkingSpace.setText("Lugar de estacionamiento: " + String.valueOf(ticket.getParkingSpace().getParkingSpaceId()));
    }

    public void setTicketData (Ticket ticket) throws SQLException {
        this.ticket = ticket;
        lbl_EntryDate.setText("Fecha de entrada: " + (ticket.getEntryDate()));
        lbl_EntryTime.setText("Hora de entrada: " + (ticket.getEntryTime()));
        lbl_TicketStatus.setText("Estado: " + String.valueOf(ticket.getTicketStatus()).replace("_", " "));
        lbl_ParkingSpace.setText("Lugar de estacionamiento: " + (ticket.getParkingSpace().getParkingSpaceId()));
        lbl_DepartureDate.setText("Fecha de salida: " + (ticket.getDepartureDate()));
        lbl_DepartureTime.setText("Hora de salida: " + ticket.getDepartureTime());
        btn_Select.setVisible(false);
    }




}
