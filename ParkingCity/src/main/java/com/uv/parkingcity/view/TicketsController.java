package com.uv.parkingcity.view;

import com.uv.parkingcity.data.entities.Ticket;
import com.uv.parkingcity.logic.manager.TicketManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TicketsController implements Initializable {
    public DatePicker datepicker_Date;
    public FlowPane pane_Tickets;
    public Label lbl_Tickets;
    public AnchorPane pane_Login;
    public TextField txt_Password;
    public Button btn_Login;
    public AnchorPane pane_TicketsList;
    TicketManager ticketManager = new TicketManager();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_Login.setOnAction(event -> {
            String enteredText = txt_Password.getText();
            String password = "safeadmin123";
            if (enteredText.equals(password)) {
                login();
            } else {
                showIncorrectPassword();
            }
        });

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

    public void login() {
        lbl_Tickets.setVisible(true);
        datepicker_Date.setVisible(true);
        pane_TicketsList.setVisible(true);
        pane_Login.setVisible(false);
    }

    public void showIncorrectPassword() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Contraseña incorrecta");
        alert.setContentText("Por favor ingrese la contraseña correcta");
        alert.showAndWait();
    }
}
