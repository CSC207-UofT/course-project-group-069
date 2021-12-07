package com.example.phase2.GUI;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Layout for the login scene
 */

public class LoginLayOut {

    public Group loginScene(TextField userNameInput, TextField passcodeInput, Button loginButton,
                            Button createUserButton) {
        Group layOut = new Group();

        Image image = new Image("file:Stage1.jpg");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(950);
        backGroundImageView.setPreserveRatio(true);

        Label appName = new Label("Meals");
        appName.setFont(Font.font("Aralia", FontWeight.BOLD, 45));
        appName.setLayoutX(400);
        appName.setLayoutY(180);

        Label userNameLabel = new Label("Username:");
        userNameLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        userNameLabel.setLayoutX(300);
        userNameLabel.setLayoutY(250);

        userNameInput.setPromptText("username");
        userNameInput.setPrefHeight(35); // for height of the box
        userNameInput.setLayoutX(380);
        userNameInput.setLayoutY(250);

        Label passcodeLabel = new Label("Passcode:");
        passcodeLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        passcodeLabel.setLayoutX(300);
        passcodeLabel.setLayoutY(300);

        passcodeInput.setPromptText("password");
        passcodeInput.setPrefHeight(35); // for height of the box
        passcodeInput.setLayoutX(380);
        passcodeInput.setLayoutY(300);

        loginButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        loginButton.setLayoutX(380);
        loginButton.setLayoutY(350);

        createUserButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        createUserButton.setLayoutX(430);
        createUserButton.setLayoutY(350);

        layOut.getChildren().addAll(backGroundImageView, appName,
                userNameLabel, userNameInput, passcodeLabel, passcodeInput
                ,loginButton, createUserButton);

        return layOut;


    }


}
