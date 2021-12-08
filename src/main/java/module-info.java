module com.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phase2 to javafx.fxml;
    exports com.example.phase2;
    exports com.example.phase2.GUI;
    opens com.example.phase2.GUI to javafx.fxml;
    exports com.example.phase2.controller;
}