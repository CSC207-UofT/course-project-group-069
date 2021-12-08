package com.example.phase2.GUI;

import com.example.phase2.controller.Controller;
import com.example.phase2.controller.Presenter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * An alert box that is responsible for asking the user which ingredient(s) they'd like to add or
 * remove from their shopping list.
 */
public class IngredientAlertBox {

    public static void display(Controller controller, Presenter presenter, String action){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Enter Ingredients");
        window.setMinWidth(350);

        Label label = new Label();
        //Cases are separate because the user can add multiple ingredients, but can only remove one
        //ingredient at a time.
        if (action.equals("add")) {
            label.setText("Enter the Ingredient you want to add. Add multiple ingredients by separating " +
                    "them with a comma (,)");
        }
        else {
            label.setText("Enter the Ingredient you want to remove.");
        }

        TextField ingNameInput = new TextField();
        ingNameInput.setPrefHeight(35); // Height of text box

        Button confirmButton = new Button("OK");
        confirmButton.setOnAction(e ->{
            //Trims the user input, so strings with only whitespaces will not be accepted.
            String result = ingNameInput.getText().trim();

            //This section checks if there is only whitespace in all the user input entries.
            //If yes, result is changed to an empty string so that a Missing Input error box can be displayed.
            char[] characters = result.toCharArray();

            boolean checker = true;
            for (char character: characters){
                if (character != ',' && character != ' '){ //Checks if there is any character other than ',' or a whitespace.
                    checker = false;
                    break;
                }
            }

            if (checker) {
                result = "";
            }

            //If input is empty, display error box and close the window, preventing further code from running.
            if (result.isEmpty()) {
                AlertBox.display("Missing input", "Empty input not accepted. Please try again.");
                window.close();
            }
            //Add whatever ingredient(s) the user inputs to the shopping list.
            else if (action.equals("add")) {
                controller.addItemAction(result);
                AlertBox.display("Success!", "Ingredient(s) added successfully! Click on Shopping List " +
                        "to view!");
            }
            else {
                controller.removeItemAction(result);
                //If the user chooses to remove an ingredient, and the inputted ingredient is not
                // in the shopping list, removeStatus will be false. This prompts an error box.
                if (!presenter.getRemoveStatus()){
                    AlertBox.display("Incorrect Input", "Ingredient not found. Please try again");
                }
                else {
                    AlertBox.display("Success!", "Ingredient removed successfully! Click on " +
                            "Shopping List to view!");
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
