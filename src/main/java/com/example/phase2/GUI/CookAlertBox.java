package com.example.phase2.GUI;

import com.example.phase2.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CookAlertBox {

    public static void display(Controller controller, String recipeName){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Cook dish?");
        window.setMinWidth(350);

        Label label = new Label();
        label.setText("Cook this dish for diner?");

        Button confirmButton = new Button("Yes");
        confirmButton.setOnAction(e -> {
            controller.cook(recipeName);
            window.close();
        } );

        Button goBackButton = new Button("No");
        goBackButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, confirmButton, goBackButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
