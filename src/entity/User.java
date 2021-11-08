package entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * represent a user in the system
 */

public class User implements Serializable {
    public String userName;
    private String email;
    private String passcode;
    public List<Ingredient> fridge;
/*
    Stuff maybe for later as the project progresses
    private String foodPreferences;
    private List<String> favorites;
    private List<Recipe> createdRecipe;
*/
    // TODO: implement this class Serializable?
    public User(String username, String password){
        userName = username;
        passcode = password;
        fridge = new ArrayList<>();
    }

    public String getPasscode(){
        return passcode;
    }

    public String getUserName() { return userName; }






}
