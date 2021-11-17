package use_case;

import entity.User;
import entity.UserList;
import gateways.GetSaveUserList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserManageLoginAndNewUser {

    private User currentUser;
    private List<CurrentUserObserver> obs = new ArrayList<>();
    private ReadWriter gateWay = new GetSaveUserList();

    public UserManageLoginAndNewUser(CurrentUserObserver observer){
        obs.add(observer);
    } 


    public boolean login(String userName, String passcode) throws Exception {


        UserList userList = gateWay.getUserList();

        if (userList.getUser(userName) == null) {
            return false;
        }
        currentUser = userList.getUser(userName);
        if (currentUser.getPasscode().equals(passcode)){
            this.notifyObservers(currentUser);
            return true;
        }
        return false;
    }

    public void logOut() throws Exception {

        UserList userList = gateWay.getUserList();
        userList.add(currentUser);
        gateWay.saveUserList(userList);
    }


    public void createUser(String username, String passcode) throws Exception {

        UserList userList = gateWay.getUserList();
        User user = new User(username, passcode);
        userList.add(user);
        gateWay.saveUserList(userList);
    }

    public void notifyObservers(User user) {
        for (CurrentUserObserver o: obs) {
            o.update(user);
        }
    }

    
}
