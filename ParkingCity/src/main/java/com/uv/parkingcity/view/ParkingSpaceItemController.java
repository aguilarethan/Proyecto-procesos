package com.uv.parkingcity.view;

import com.uv.parkingcity.data.entities.ParkingSpace;
import com.uv.parkingcity.data.entities.enums.ParkingSpaceStatus;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ParkingSpaceItemController implements Initializable {

    public ToggleButton btn_ParkingSpace;
    ParkingSpace parkingSpace = new ParkingSpace();
    ParkingSpacesAvailableController parkingSpacesAvailableController = new ParkingSpacesAvailableController();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_ParkingSpace.setOnAction(event -> {
            if (parkingSpace.getParkingSpaceStatus() == ParkingSpaceStatus.VACIO) {
                btn_ParkingSpace.setStyle("-fx-background-color: #CF6679; -fx-background-radius: 10;");
                parkingSpace.setParkingSpaceStatus(ParkingSpaceStatus.OCUPADO);
                parkingSpacesAvailableController.generateTicket(parkingSpace);
            }
        });

    }


    public void setParkingSpaceData (ParkingSpace parkingSpace, ParkingSpacesAvailableController parkingSpacesAvailableController) {
        this.parkingSpace = parkingSpace;
        this.parkingSpacesAvailableController = parkingSpacesAvailableController;
        btn_ParkingSpace.setText(parkingSpace.getAreaId() + "-" + parkingSpace.getParkingSpaceId());

        if (parkingSpace.getParkingSpaceStatus() == ParkingSpaceStatus.OCUPADO) {
            btn_ParkingSpace.setStyle("-fx-background-color: #CF6679; -fx-background-radius: 10;");
        }

    }


}
