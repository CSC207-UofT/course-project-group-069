package meals.GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPage {

    private ImageView backGroundImageView;
    private Label appName;
    private Label userNameLabel;
    private TextField userNameInput;
    private Label passcodeLabel;
    private TextField passcodeInput;
    private Button loginButton;
    private Button createUserButton;

    public LoginPage(){

        Image image = new Image("file:Stage1.jpg");
        backGroundImageView = new ImageView(image);
        backGroundImageView.setFitHeight(1700);
        backGroundImageView.setFitWidth(950);
        backGroundImageView.setPreserveRatio(true);

        appName = new Label("Meals");
        appName.setFont(Font.font("Aralia", FontWeight.BOLD, 45));
        appName.setLayoutX(400);
        appName.setLayoutY(180);

        userNameLabel = new Label("Username:");
        userNameLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        userNameLabel.setLayoutX(300);
        userNameLabel.setLayoutY(250);

        userNameInput = new TextField();
        userNameInput.setPromptText("username");
        userNameInput.setPrefHeight(35); // for height of the box
        userNameInput.setLayoutX(380);
        userNameInput.setLayoutY(250);

        passcodeLabel = new Label("Passcode:");
        passcodeLabel.setFont(Font.font("Aralia", FontWeight.EXTRA_BOLD, 15));
        passcodeLabel.setLayoutX(300);
        passcodeLabel.setLayoutY(300);

        passcodeInput = new TextField();
        passcodeInput.setPromptText("password");
        passcodeInput.setPrefHeight(35); // for height of the box
        passcodeInput.setLayoutX(380);
        passcodeInput.setLayoutY(300);

        loginButton = new Button("Log In");
        loginButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        loginButton.setLayoutX(380);
        loginButton.setLayoutY(350);

        createUserButton = new Button("Create Account");
        createUserButton.setFont(Font.font("Aralia", FontWeight.BOLD, 10));
        createUserButton.setLayoutX(430);
        createUserButton.setLayoutY(350);

    }

    public ImageView getBackGroundImageView() {return backGroundImageView;}

    public Label getAppName(){return appName;}

    public Label getUserNameLabel(){return userNameLabel;}

    public TextField getUserNameInput(){return userNameInput;}

    public Label getPasscodeLabel(){return passcodeLabel;}

    public TextField getPasscodeInput(){return passcodeInput;}

    public Button getLoginButton(){return loginButton;}

    public Button getCreateUserButton(){return createUserButton;}

}
