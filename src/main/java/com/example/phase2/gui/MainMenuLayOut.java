package com.example.phase2.gui;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Lay out for the main menu scene
 */

public class MainMenuLayOut {

    public Group mainMenuScene(Button addIngButton, Button findRecipeButton, Button viewFridgeButton,
                               Button shoppingListButton, Button logoutButton){
        Group layout = new Group();

        Image image = new Image("file:stage2.jpg");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(1100);
        backGroundImageView.setPreserveRatio(true);

        addIngButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        addIngButton.setLayoutX(380);
        addIngButton.setLayoutY(120);

        findRecipeButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        findRecipeButton.setLayoutX(397);
        findRecipeButton.setLayoutY(200);

        viewFridgeButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        viewFridgeButton.setLayoutX(397);
        viewFridgeButton.setLayoutY(280);

        shoppingListButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        shoppingListButton.setLayoutX(387);
        shoppingListButton.setLayoutY(360);

        logoutButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        logoutButton.setLayoutX(420);
        logoutButton.setLayoutY(440);

        layout.getChildren().addAll(backGroundImageView, addIngButton,
                findRecipeButton, viewFridgeButton, shoppingListButton, logoutButton);

        return layout;

    }
}
