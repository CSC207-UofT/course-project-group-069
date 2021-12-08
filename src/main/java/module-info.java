module com.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phase2 to javafx.fxml;
    exports com.example.phase2;
    exports com.example.phase2.gui;
    exports com.example.phase2.controller;
    opens com.example.phase2.gui to javafx.fxml;
}