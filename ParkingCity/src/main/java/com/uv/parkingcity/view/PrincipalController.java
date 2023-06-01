package com.uv.parkingcity.view;

import com.uv.parkingcity.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    private final ToggleGroup sideMenuGroup = new ToggleGroup();
    public RadioButton btn_ParkingSpacesAvailable;
    public RadioButton btn_PayTicket;
    public RadioButton btn_AllTickets;
    public BorderPane pane_Principal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initilizeButton(btn_ParkingSpacesAvailable);
        initilizeButton(btn_PayTicket);
        initilizeButton(btn_AllTickets);

        setView("/com/uv/parkingcity/view/ParkingSpacesAvailableWindow.fxml");

        btn_ParkingSpacesAvailable.setOnAction(event -> {

        });

        btn_PayTicket.setOnAction(event -> {

        });

        btn_AllTickets.setOnAction(event -> {

        });
    }

    public void setView(String path){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane_Principal.setCenter(root);
    }

    private void initilizeButton(RadioButton button){
        button.setToggleGroup(sideMenuGroup);
    }
}
