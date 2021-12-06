package com.example.phase2.GUI;

import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FindRecipeBox {

    private static Scene sceneFindRecipe, sceneRecipeDirection;
    private static Controller controller;
    private static Presenter presenter;

    public static void display(Controller c, Presenter p) {

        controller = c;
        presenter = p;

        controller.getAvailableRecipe();
        String availableRecipe = presenter.getAvailableRecipes();
        Label availableRecipeLabel = new Label(availableRecipe);

        DisplayDirectionLayOut ddlo =  new DisplayDirectionLayOut();

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Find Recipe");

        TextField getRecipeNameInput = new TextField();

        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> window.setScene(sceneFindRecipe));

        Button cookButton = new Button("Cooked it");
        cookButton.setOnAction(e -> {
            CookAlertBox.display(controller, getRecipeNameInput.getText());
            window.close();
        });

        Button getDirectionButton = new Button("Get Direction");
        getDirectionButton.setOnAction(e -> {
            controller.getDirectionAction(getRecipeNameInput.getText());
            String recipeDirection = presenter.getRecipeDirection();
            Label recipeDirectionLabel = new Label(recipeDirection);
            sceneRecipeDirection = new Scene(ddlo.displayDirection(recipeDirectionLabel, goBackButton, cookButton),
                    970, 600);
            window.setScene(sceneRecipeDirection);
        });

        Button finishButton = new Button("Close Menu");
        finishButton.setOnAction(e -> window.close());

        FindRecipeLayOut findRecipeLayOut = new FindRecipeLayOut();

        DisplayDirectionLayOut displayDirectionLayOut = new DisplayDirectionLayOut();

        sceneFindRecipe = new Scene(findRecipeLayOut.findRecipeScene(availableRecipeLabel, getRecipeNameInput,
                getDirectionButton, finishButton), 970, 600);

        window.setScene(sceneFindRecipe);
        window.showAndWait();

    }
}
