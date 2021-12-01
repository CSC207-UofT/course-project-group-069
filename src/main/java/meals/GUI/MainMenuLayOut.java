package meals.GUI;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainMenuLayOut {

    public Group mainMenuScene(Button addIngButton, Button findRecipeButton, Button viewFridgeButton,
                               Button logoutButton){
        Group layout = new Group();

        Image image = new Image("file:stage2.jpg");
        ImageView backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(1100);
        backGroundImageView.setPreserveRatio(true);

        addIngButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        addIngButton.setLayoutX(400);
        addIngButton.setLayoutY(200);

        findRecipeButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        findRecipeButton.setLayoutX(420);
        findRecipeButton.setLayoutY(280);

        viewFridgeButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        viewFridgeButton.setLayoutX(420);
        viewFridgeButton.setLayoutY(360);

        logoutButton.setFont(Font.font("Aralia", FontWeight.BOLD, 20));
        logoutButton.setLayoutX(440);
        logoutButton.setLayoutY(440);

        layout.getChildren().addAll(backGroundImageView, addIngButton,
                findRecipeButton, viewFridgeButton, logoutButton);

        return layout;

    }
}
