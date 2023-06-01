package com.uv.parkingcity.view;

import com.uv.parkingcity.HelloApplication;
import com.uv.parkingcity.data.entities.ParkingSpace;
import com.uv.parkingcity.data.entities.Ticket;
import com.uv.parkingcity.data.entities.enums.ParkingSpaceStatus;
import com.uv.parkingcity.data.entities.enums.TicketStatus;
import com.uv.parkingcity.logic.manager.ParkingSpaceManager;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ParkingSpacesAvailableController implements Initializable {
    public FlowPane pane_ParkingSpaceFileOne;
    public FlowPane pane_ParkingSpaceFileTwo;
    public FlowPane pane_ParkingSpaceFileThree;
    public AnchorPane pane_Ticket;
    public RadioButton btn_Level1;
    public RadioButton btn_Level2;
    public RadioButton btn_Level3;
    public RadioButton btn_Level4;
    public RadioButton btn_Bikes;
    public Button btn_GenerateTickets;
    public Button btn_Accept;
    public Label lbl_EntryDate;
    public Label lbl_EntryTime;
    public Label lbl_TicketStatus;

    ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();
    TicketManager ticketManager = new TicketManager();
    ToggleGroup group = new ToggleGroup();
    Ticket ticket = new Ticket();
    ParkingSpace parkingSpace = new ParkingSpace();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_Level1.setToggleGroup(group);
        btn_Level2.setToggleGroup(group);
        btn_Level3.setToggleGroup(group);
        btn_Level4.setToggleGroup(group);
        btn_Bikes.setToggleGroup(group);

        btn_Level1.setOnAction(event -> {
            getParkingSpacesByArea(btn_Level1.getText());
        });

        btn_Level2.setOnAction(event -> {
            getParkingSpacesByArea(btn_Level2.getText());
        });

        btn_Level3.setOnAction(event -> {
            getParkingSpacesByArea(btn_Level3.getText());
        });

        btn_Level4.setOnAction(event -> {
            getParkingSpacesByArea(btn_Level4.getText());
        });

        btn_Bikes.setOnAction(event -> {
            getParkingSpacesByArea(btn_Bikes.getText());
        });

        btn_GenerateTickets.setOnAction(event -> {
            saveTicket();
        });

        btn_Accept.setOnAction(event -> {
            pane_Ticket.setVisible(false);
        });
    }

    public void getParkingSpacesByArea (String area) {
        ArrayList<ParkingSpace> parkingSpaces = new ArrayList<>();

        try {
            switch (area) {
                case "Nivel 1" -> {
                    parkingSpaces = parkingSpaceManager.getParkingSpacesByAreaId("A");
                    createParkingSpaceItem(parkingSpaces);
                }
                case "Nivel 2"-> {
                    parkingSpaces = parkingSpaceManager.getParkingSpacesByAreaId("B");
                    createParkingSpaceItem(parkingSpaces);
                }
                case "Nivel 3"-> {
                    parkingSpaces = parkingSpaceManager.getParkingSpacesByAreaId("C");
                    createParkingSpaceItem(parkingSpaces);
                }
                case "Nivel 4"-> {
                    parkingSpaces = parkingSpaceManager.getParkingSpacesByAreaId("D");
                    createParkingSpaceItem(parkingSpaces);
                }
                case "Motos"-> {
                    parkingSpaces = parkingSpaceManager.getParkingSpacesByAreaId("M");
                    createParkingSpaceItem(parkingSpaces);
                }
            }
        } catch (SQLException | IOException e) {
            showAlert();
        }
    }

    public void createParkingSpaceItem(ArrayList<ParkingSpace> parkingSpaces) throws IOException {

        ArrayList<FlowPane> panes = new ArrayList<>();
        panes.add(pane_ParkingSpaceFileOne);
        panes.add(pane_ParkingSpaceFileTwo);
        panes.add(pane_ParkingSpaceFileThree);

        clearPanes();

        int counter = 0;
        int paneIndex = 0;

        for (ParkingSpace parkingSpace : parkingSpaces) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/uv/parkingcity/view/ParkingSpaceItem.fxml"));
            Node node = fxmlLoader.load();

            ParkingSpaceItemController parkingSpaceItemController = fxmlLoader.getController();
            parkingSpaceItemController.setParkingSpaceData(parkingSpace, this);


            panes.get(paneIndex).getChildren().add(node);

            counter++;

            if (counter == 18 && paneIndex < panes.size() - 1) {
                counter = 0;
                paneIndex++;
            } else if (counter == 18 && paneIndex == panes.size() - 1) {
                counter = 0;
                paneIndex = 0;
            }


        }
    }

    public void generateTicket (ParkingSpace parkingSpace) {
        ticket.setParkingSpace(parkingSpace);
        ticket.setEntryDate(LocalDate.now());
        ticket.setEntryTime(LocalTime.now());
        ticket.setTicketStatus(TicketStatus.SIN_PAGAR);
        this.parkingSpace = parkingSpace;
    }

    public void saveTicket() {
        try {
            ticketManager.addTicket(ticket);
            parkingSpaceManager.updateParkingSpaceStatus(parkingSpace);
            lbl_EntryDate.setText("Fecha de entrada: " + String.valueOf(ticket.getEntryDate()));
            lbl_EntryTime.setText("Hora de entrada: " + String.valueOf(ticket.getEntryTime()));
            lbl_TicketStatus.setText("Estado: " + String.valueOf(ticket.getTicketStatus()).replace("_", " "));
            pane_Ticket.setVisible(true);
        } catch (SQLException e) {
            showAlertTicket();
        }
    }

    public void clearPanes () {
        pane_ParkingSpaceFileOne.getChildren().clear();
        pane_ParkingSpaceFileTwo.getChildren().clear();
        pane_ParkingSpaceFileThree.getChildren().clear();
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("No pudimos cargar los espacios de estacionamiento. Estamos trabajando para solucionarlo");
        alert.showAndWait();
    }

    private void showAlertTicket(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("No pudimos generar su ticket. Estamos trabajando para solucionarlo");
        alert.showAndWait();
    }

}
