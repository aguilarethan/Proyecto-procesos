package com.uv.parkingcity.view;

import com.uv.parkingcity.data.entities.Ticket;
import com.uv.parkingcity.logic.manager.TicketManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TicketsController implements Initializable {
    public DatePicker datepicker_Date;
    public FlowPane pane_Tickets;
    TicketManager ticketManager = new TicketManager();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datepicker_Date.valueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                createTicketItem();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void createTicketItem() throws IOException, SQLException {
        pane_Tickets.getChildren().clear();
        for (Ticket ticket : ticketManager.getAllTicketsByEntryDate(datepicker_Date.getValue())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/uv/parkingcity/view/TicketItem.fxml"));
            Node node = fxmlLoader.load();

            TicketItemController ticketItemController = fxmlLoader.getController();
            ticketItemController.setTicketData(ticket);

            pane_Tickets.getChildren().add(node);
        }
    }
}
