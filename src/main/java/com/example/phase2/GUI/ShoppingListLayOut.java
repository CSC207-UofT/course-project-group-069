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
 * A class that sets the layout of the ShoppingListBox screen.
 */
public class ShoppingListLayOut {

    public Group shoppingListScene(Label ingredientsLabel, Button addIngButton, Button remIngButton,
                                   Button backButton){

        Group layOut = new Group();

        Image image = new Image("file:shoppinglist.jpg");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(600);
        backGroundImageView.setFitWidth(900);
        backGroundImageView.setPreserveRatio(true);

        Label titleLabel = new Label("Things to Get");
        titleLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 45));
        titleLabel.setLayoutX(150);
        titleLabel.setLayoutY(70);

        ingredientsLabel.setFont(Font.font("Aralia", FontWeight.BOLD, 18));
        ingredientsLabel.setWrapText(true);
        ingredientsLabel.setTextAlignment(TextAlignment.JUSTIFY);
        ingredientsLabel.setMaxWidth(370);
        ingredientsLabel.setLayoutX(110);
        ingredientsLabel.setLayoutY(170);

        addIngButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        addIngButton.setLayoutX(550);
        addIngButton.setLayoutY(150);

        remIngButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        remIngButton.setLayoutX(550);
        remIngButton.setLayoutY(250);

        backButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        backButton.setLayoutX(550);
        backButton.setLayoutY(350);

        layOut.getChildren().addAll(backGroundImageView, ingredientsLabel, titleLabel, addIngButton,
                remIngButton, backButton);

        return layOut;
    }
}
