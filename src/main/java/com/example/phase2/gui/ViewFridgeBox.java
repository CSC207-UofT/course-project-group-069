package com.example.phase2.gui;

import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Displays the user's fridge
 */

public class ViewFridgeBox {

    public static void display(Controller c, Presenter p) {

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

        c.viewFridgeAction();
        String fridge = p.getFridge();
        Label fridgeLabel = new Label(fridge);
        fridgeLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        fridgeLabel.setWrapText(true);
        fridgeLabel.setTextAlignment(TextAlignment.JUSTIFY);
        fridgeLabel.setMaxWidth(200);
        fridgeLabel.setLayoutX(190);
        fridgeLabel.setLayoutY(170);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Please enter a username");
        usernameInput.setPrefHeight(35); // for height of the box
        usernameInput.setLayoutX(370);
        usernameInput.setLayoutY(220);

        TextField removeIngInput = new TextField();
        removeIngInput.setPromptText("Please enter an Ingredient to remove");
        removeIngInput.setPrefHeight(35); // for height of the box
        removeIngInput.setLayoutX(280);
        removeIngInput.setLayoutY(450);

        Button removeIngButton = new Button("Remove Ingredient");
        removeIngButton.setFont(Font.font("Aralia", FontWeight.BOLD, 13));
        removeIngButton.setLayoutX(140);
        removeIngButton.setLayoutY(450);
        removeIngButton.setOnAction(e -> {
            c.removeIngAction(removeIngInput.getText());
            window.close();
        });

        Button closeButton = new Button("Close Fridge");
        closeButton.setFont(Font.font("Aralia", FontWeight.BOLD, 13));
        closeButton.setLayoutX(210);
        closeButton.setLayoutY(500);
        closeButton.setOnAction(e -> window.close());

        layout.getChildren().addAll(backGroundImageView, titleLabel, fridgeLabel, removeIngInput,
                removeIngButton, closeButton);

        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.showAndWait();

    }
}
