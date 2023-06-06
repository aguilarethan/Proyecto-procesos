package com.uv.parkingcity.view;

import com.uv.parkingcity.data.entities.ParkingSpace;
import com.uv.parkingcity.data.entities.Ticket;
import com.uv.parkingcity.data.entities.enums.ParkingSpaceStatus;
import com.uv.parkingcity.data.entities.enums.TicketStatus;
import com.uv.parkingcity.logic.manager.ParkingSpaceManager;
import com.uv.parkingcity.logic.manager.TicketManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.ResourceBundle;

public class PayTicketController implements Initializable {


    public Button btn_Pay;
    public Button btn_Search;
    public TextField txt_AmountToPay;
    public TextField txt_ParkingSpace;
    public FlowPane pane_Tickets;
    public Label lbl_AmountToPay;
    public Label lbl_AmountToPayCount;
    TicketManager ticketManager = new TicketManager();
    ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_Search.setOnAction(event -> {
            try {
                createTicketItem();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void createTicketItem() throws SQLException, IOException {
        Ticket ticket = ticketManager.getTicketByParkingSpaceId(Integer.parseInt(txt_ParkingSpace.getText()));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uv/parkingcity/view/TicketItem.fxml"));
        Node node = fxmlLoader.load();
        pane_Tickets.getChildren().clear();
        pane_Tickets.getChildren().add(node);

        TicketItemController ticketItemController = fxmlLoader.getController();
        ticketItemController.setTicketData(ticket, this);
    }

    public void calculateTotal(Ticket ticket) {
        LocalDateTime localDateTime = LocalDateTime.of(ticket.getEntryDate(), ticket.getEntryTime());
        long minutes = ChronoUnit.MINUTES.between(localDateTime, LocalDateTime.now());
        int amountToPay = Math.toIntExact(minutes);
        setVisiblePay();

        lbl_AmountToPayCount.setText("Total a pagar: $" + amountToPay);

        btn_Pay.setOnAction(event -> {
            String enteredText = txt_AmountToPay.getText();
            if (!enteredText.isEmpty()) {
                try {
                    int enteredAmount = Integer.parseInt(enteredText);
                    if (enteredAmount == amountToPay) {
                        ticket.setTicketStatus(TicketStatus.PAGADO);
                        ticket.setDepartureDate(LocalDate.now());
                        ticket.setDepartureTime(LocalTime.now());
                        ParkingSpace temporalParkingSpace = ticket.getParkingSpace();
                        temporalParkingSpace.setParkingSpaceStatus(ParkingSpaceStatus.VACIO);
                        if (ticketManager.updateTicketStatus(ticket) == 1) {
                            parkingSpaceManager.updateParkingSpaceStatus(temporalParkingSpace);
                            showSuccessfulPayment();
                        }
                    } else {
                        showCorrectAmount();
                    }
                } catch (NumberFormatException | SQLException e) {
                    showValidNumber();
                }
            } else {
                showFieldEmpty();
            }
        });
    }


    public void showSuccessfulPayment() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ticket pagado");
        alert.setContentText("Pago exitoso");
        alert.showAndWait();
    }

    public void showCorrectAmount() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setContentText("Por favor ingrese el monto a pagar correcto");
        alert.showAndWait();
    }

    public void showValidNumber() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setContentText("Por favor ingrese un número válido");
        alert.showAndWait();
    }

    public void showFieldEmpty() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setContentText("Por favor ingrese el total a pagar");
        alert.showAndWait();
    }
    public void setVisiblePay () {
        lbl_AmountToPayCount.setVisible(true);
        lbl_AmountToPay.setVisible(true);
        btn_Pay.setVisible(true);
        txt_AmountToPay.setVisible(true);
    }


}
