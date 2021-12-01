package com.example.phase2.GUI;

import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewFridgeBox {

    private static Controller controller;
    private static Presenter presenter;

    public static void display(Controller c, Presenter p) {

        presenter = p;
        controller = c;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Fridge");

        Group layout = new Group();

        Image image = new Image("file:fridge.jpg");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(1100);
        backGroundImageView.setPreserveRatio(true);

        Label titleLabel = new Label("Your Fridge");
        titleLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 40));
        titleLabel.setLayoutX(170);
        titleLabel.setLayoutY(90);

        controller.viewFridgeAction();
        String fridge = presenter.getFridge();
        Label fridgeLabel = new Label(fridge);
        fridgeLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        fridgeLabel.setWrapText(true);
        fridgeLabel.setTextAlignment(TextAlignment.JUSTIFY);
        fridgeLabel.setMaxWidth(200);
        fridgeLabel.setLayoutX(190);
        fridgeLabel.setLayoutY(170);

        Button closeButton = new Button("Close Fridge");
        closeButton.setFont(Font.font("Aralia", FontWeight.BOLD, 13));
        closeButton.setLayoutX(210);
        closeButton.setLayoutY(500);
        closeButton.setOnAction(e -> window.close());

        layout.getChildren().addAll(backGroundImageView, titleLabel, fridgeLabel, closeButton);

        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.showAndWait();

    }
}
