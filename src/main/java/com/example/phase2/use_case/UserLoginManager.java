package com.example.phase2.use_case;

import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.entity.User;
import com.example.phase2.entity.UserList;
import com.example.phase2.gateways.GetSaveUserList;
import com.example.phase2.gateways.ReadWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages user's login, logout, and creating new user actions.
 */

public class UserLoginManager {

    private User currentUser;
    private final List<CurrentUserObserver> obs = new ArrayList<>();
    private final ReadWriter gateWay = new GetSaveUserList();
    private final OutputBoundary outputBoundary;

    public UserLoginManager(CurrentUserObserver observerFridge, CurrentUserObserver observerRecipe,
                            CurrentUserObserver observerShoppingList, OutputBoundary presenter){
        outputBoundary = presenter;
        obs.add(observerFridge);
        obs.add(observerRecipe);
        obs.add(observerShoppingList);
    }

    /**
     * Run the login method
     * @param userName username of the user
     * @param passcode passcode of the user
     */
    public void login(String userName, String passcode) {

        try {
            UserList userList = gateWay.getUserList();

            if (userList.getUser(userName) == null) {
                return;
            }
            currentUser = userList.getUser(userName);
            if (currentUser.getPasscode().equals(passcode)){
                this.notifyObservers(currentUser);
                outputBoundary.updateLoginStatus();
            }
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    /**
     * Run the logout method and saves the changes the user made in the current session
     * through serialization
     */
    public void logOut() {

        try {
            UserList userList = gateWay.getUserList();
            userList.add(currentUser);
            gateWay.saveUserList(userList);
        } catch (IOException | ClassNotFoundException ignored){
        }
    }

    /**
     * Creating a new user given a choice of username and passcode
     * and save the new user into the ser file through serialization
     * which enables this new user to login
     * @param username A user's new username
     * @param passcode A user's new passcode
     */
    public void createUser(String username, String passcode) {

        try {
            UserList userList = gateWay.getUserList();
            User user = new User(username, passcode);
            userList.add(user);
            gateWay.saveUserList(userList);
        } catch (IOException | ClassNotFoundException ignored){
        }
    }

    /**
     * Notify the observer given a user
     * @param user A user object which represent a user who uses the program
     */
    public void notifyObservers(User user) {
        for (CurrentUserObserver o: obs) {
            o.update(user);
        }
    }

    
}
