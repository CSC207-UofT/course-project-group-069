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
 * Displays creating new user scene
 */

public class CreateUserBox {

    private static Controller controller;

    public static void display(Controller c){

        controller = c;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Creat New User");

        Group layout = new Group();

        Image image = new Image("file:Createuser.png");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(1000);
        backGroundImageView.setPreserveRatio(true);

        Label createUserLabel = new Label("Create an Account");
        createUserLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 40));
        createUserLabel.setLayoutX(290);
        createUserLabel.setLayoutY(90);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        usernameLabel.setLayoutX(280);
        usernameLabel.setLayoutY(220);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Please enter a username");
        usernameInput.setPrefHeight(35); // for height of the box
        usernameInput.setLayoutX(370);
        usernameInput.setLayoutY(220);

        Label passcodeLabel = new Label("Passcode:");
        passcodeLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        passcodeLabel.setLayoutX(280);
        passcodeLabel.setLayoutY(300);

        TextField passcodeInput = new TextField();
        passcodeInput.setPromptText("Please enter a password");
        passcodeInput.setPrefHeight(35); // for height of the box
        passcodeInput.setLayoutX(370);
        passcodeInput.setLayoutY(300);

        Button creatAccountButton = new Button("Create Account");
        creatAccountButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        creatAccountButton.setLayoutX(370);
        creatAccountButton.setLayoutY(370);
        creatAccountButton.setOnAction(e -> {
            controller.createUserAction(usernameInput.getText(), passcodeInput.getText());
            window.close();
        });

        layout.getChildren().addAll(backGroundImageView, createUserLabel, usernameLabel, usernameInput, passcodeLabel,
                passcodeInput, creatAccountButton);
        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.showAndWait();
    }
}
