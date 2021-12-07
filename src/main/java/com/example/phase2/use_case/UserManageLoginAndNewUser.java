package com.example.phase2.use_case;

import com.example.phase2.controller.OutputBoundary;
import com.example.phase2.controller.Presenter;
import com.example.phase2.entity.User;
import com.example.phase2.entity.UserList;
import com.example.phase2.gateways.GetSaveUserList;
import com.example.phase2.gateways.ReadWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserManageLoginAndNewUser {

    private User currentUser;
    private List<CurrentUserObserver> obs = new ArrayList<>();
    private ReadWriter gateWay = new GetSaveUserList();
    private OutputBoundary outputBoundary;

    public UserManageLoginAndNewUser(CurrentUserObserver observerFridge, CurrentUserObserver observerRecipe,
                                     CurrentUserObserver observerShoppingList, OutputBoundary presenter){
        outputBoundary = presenter;
        obs.add(observerFridge);
        obs.add(observerRecipe);
        obs.add(observerShoppingList);
    } 


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
        } catch (IOException i) {
            return;
        } catch (ClassNotFoundException c){
            return;
        }
    }

    public void logOut() {

        try {
            UserList userList = gateWay.getUserList();
            userList.add(currentUser);
            gateWay.saveUserList(userList);
        } catch (IOException i){
            return;
        } catch (ClassNotFoundException c){
            return;
        }
    }


    public void createUser(String username, String passcode) {

        try {
            UserList userList = gateWay.getUserList();
            User user = new User(username, passcode);
            userList.add(user);
            gateWay.saveUserList(userList);
        } catch (IOException i){
            return;
        } catch (ClassNotFoundException c){
            return;
        }
    }

    public void notifyObservers(User user) {
        for (CurrentUserObserver o: obs) {
            o.update(user);
        }
    }

    
}
