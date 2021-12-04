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

public class DisplayDirectionLayOut {

    public DisplayDirectionLayOut(){}

    public Group displayDirection (Label recipeDirectionLabel, Button goBackButton, Button cookButton) {

        Group layOut = new Group();

        Image image = new Image("file:menu.png");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(950);
        backGroundImageView.setPreserveRatio(true);

        Label directionLabel = new Label("Direction");
        directionLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 45));
        directionLabel.setLayoutX(150);
        directionLabel.setLayoutY(70);

        recipeDirectionLabel.setFont(Font.font("Aralia", FontWeight.SEMI_BOLD, 15));
        recipeDirectionLabel.setWrapText(true);
        recipeDirectionLabel.setTextAlignment(TextAlignment.LEFT);
        recipeDirectionLabel.setMaxWidth(220);
        recipeDirectionLabel.setLayoutX(160);
        recipeDirectionLabel.setLayoutY(170);

        cookButton.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        cookButton.setLayoutX(680);
        cookButton.setLayoutY(280);

        goBackButton.setFont(Font.font("Aralia", FontWeight.BOLD, 15));
        goBackButton.setLayoutX(680);
        goBackButton.setLayoutY(380);

        layOut.getChildren().addAll(backGroundImageView, directionLabel, recipeDirectionLabel,
                cookButton, goBackButton);

        return layOut;
    }
}
