package com.example.phase2.gui;

import com.example.phase2.controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Displays add ingredient scene
 */

public class AddIngredientBox {

    private static Controller controller;

    public static void display(Controller c) {

        controller = c;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Ingredient");

        Group layout = new Group();

        Image image = new Image("file:Ingredients.jpg");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(1100);
        backGroundImageView.setPreserveRatio(true);

        Label addIngLabel = new Label("Add Ingredients");
        addIngLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 40));
        addIngLabel.setLayoutX(290);
        addIngLabel.setLayoutY(370);

        Label ingNameLabel = new Label("Ingredient Name:");
        ingNameLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        ingNameLabel.setLayoutX(80);
        ingNameLabel.setLayoutY(460);

        TextField ingNameInput = new TextField();
        ingNameInput.setPrefHeight(35); // for height of the box
        ingNameInput.setLayoutX(210);
        ingNameInput.setLayoutY(460);

        Label ingTypeLabel = new Label("Ingredient Type:");
        ingTypeLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        ingTypeLabel.setLayoutX(480);
        ingTypeLabel.setLayoutY(460);

        TextField ingTypeInput = new TextField();
        ingTypeInput.setPromptText("Optional");
        ingTypeInput.setPrefHeight(35); // for height of the box
        ingTypeInput.setLayoutX(610);
        ingTypeInput.setLayoutY(460);

        Button storeIngButton = new Button("Store");
        storeIngButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        storeIngButton.setLayoutX(390);
        storeIngButton.setLayoutY(540);
        storeIngButton.setOnAction(e -> {
            controller.addIngAction(ingNameInput.getText(), ingTypeInput.getText());
            ingNameInput.clear();
            ingTypeInput.clear();
            AlertBox.display("Ingredient Added", "Ingredient Added");
        });

        Button finishButton = new Button("Done");
        finishButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        finishButton.setLayoutX(450);
        finishButton.setLayoutY(540);
        finishButton.setOnAction(e -> window.close());

        layout.getChildren().addAll(backGroundImageView, addIngLabel, ingNameLabel, ingNameInput, ingTypeLabel,
                ingTypeInput, storeIngButton, finishButton);

        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.showAndWait();

    }
}
