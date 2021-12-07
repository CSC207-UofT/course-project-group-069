package com.example.phase2.GUI;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * Lay out for the find recipe scene
 */

public class FindRecipeLayOut {

    public Group findRecipeScene(Label availableRecipeLabel, TextField recipeNameInput, Button getDirectionButton,
                            Button finishButton) {

        Group layOut = new Group();

        Image image = new Image("file:menu.png");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(950);
        backGroundImageView.setPreserveRatio(true);

        Label menuLabel = new Label("Recipe Book");
        menuLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 45));
        menuLabel.setLayoutX(150);
        menuLabel.setLayoutY(70);

        availableRecipeLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        availableRecipeLabel.setWrapText(true);
        availableRecipeLabel.setTextAlignment(TextAlignment.JUSTIFY);
        availableRecipeLabel.setMaxWidth(200);
        availableRecipeLabel.setLayoutX(180);
        availableRecipeLabel.setLayoutY(170);

        Label getDirectionLabel = new Label("Get direction for a recipe:");
        getDirectionLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        getDirectionLabel.setLayoutX(520);
        getDirectionLabel.setLayoutY(180);

        recipeNameInput.setPromptText("Please enter a Recipe");
        recipeNameInput.setPrefHeight(35); // for height of the box
        recipeNameInput.setLayoutX(710);
        recipeNameInput.setLayoutY(180);

        getDirectionButton.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        getDirectionButton.setLayoutX(680);
        getDirectionButton.setLayoutY(280);

        finishButton.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        finishButton.setLayoutX(680);
        finishButton.setLayoutY(380);

        layOut.getChildren().addAll(backGroundImageView, menuLabel, availableRecipeLabel,
                getDirectionLabel, recipeNameInput, getDirectionButton, finishButton);

        return layOut;
    }
}
