module com.uv.parkingcity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.uv.parkingcity to javafx.fxml;
    exports com.uv.parkingcity;
    exports com.uv.parkingcity.view;
    opens com.uv.parkingcity.view to javafx.fxml;
}