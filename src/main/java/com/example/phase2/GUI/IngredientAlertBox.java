package com.example.phase2.GUI;

import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class IngredientAlertBox {

    public static void display(Controller controller, Presenter presenter, String action){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Enter Ingredient");
        window.setMinWidth(350);

        Label label = new Label();
        label.setText("Enter the Ingredient you want to " + action + ".");

        TextField ingNameInput = new TextField();
        ingNameInput.setPrefHeight(35); // Height of text box

        Button confirmButton = new Button("OK");
        confirmButton.setOnAction(e ->{
            //If input is empty, display error box and close the window, preventing further code from running.
            if (ingNameInput.getText().isEmpty()) {
                AlertBox.display("Missing input", "Empty input not accepted. Please try again.");
                window.close();
            }
            else if (action.equals("add")) {
                controller.addItemAction(ingNameInput.getText());
                AlertBox.display("Success!", "Ingredient added successfully! Click on Shopping List " +
                        "to view!");
            }
            else {
                controller.removeItemAction(ingNameInput.getText());
                //containStatus will be false if the user chooses to remove an ingredient, and
                //the inputted ingredient is not in the shopping list. This prompts an error box.
                if (!presenter.getContainStatus()){
                    AlertBox.display("Incorrect Input", "Ingredient not found. Please try again");
                }
                else {
                    AlertBox.display("Success!", "Ingredient remove successfully! Click on " +
                            "Shopping List to view!");
                    //Since the inputted ingredient was in the shopping list, containStatus is now
                    //true. It needs to be set back to false so that further ingredients can be removed.
                    presenter.updateContainStatus();
                }
            }
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, ingNameInput, confirmButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
