package com.example.phase2.GUI;

import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShoppingListBox {

    private static Scene sceneShoppingList;
    private static Controller controller;
    private static Presenter presenter;

    public static void display(Controller c, Presenter p){

        controller = c;
        presenter = p;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Shopping List");

        controller.viewShoppingListAction();
        String items = presenter.getShoppingList();
        Label ingredients = new Label(items);

        Button addIngButton = new Button("Add Ingredient");
        addIngButton.setOnAction(e -> {
            IngredientAlertBox.display(controller, presenter, "add");
            window.close();
        });

        Button remIngButton = new Button("Remove Ingredient");
        remIngButton.setOnAction(e -> {
            IngredientAlertBox.display(controller, presenter, "remove");
            window.close();
        });

        Button backButton = new Button("Close Menu");
        backButton.setOnAction(e -> window.close());

        ShoppingListLayOut layOut = new ShoppingListLayOut();

        sceneShoppingList = new Scene(layOut.shoppingListScene(ingredients, addIngButton, remIngButton,
                backButton), 900, 600);

        window.setScene(sceneShoppingList);
        window.showAndWait();

    }
}
