package use_case;

import entity.User;
import entity.UserList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserManageLoginAndNewUser {

    private UserList userList = new UserList();
    private User currentUser;
    private List<CurrentUserObserver> obs = new ArrayList<>();

    public UserManageLoginAndNewUser(CurrentUserObserver observer){
        obs.add(observer);
    } 


    public boolean login(String userName, String passcode) throws Exception {

        FileInputStream fis = new FileInputStream("userlist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserList users = (UserList) ois.readObject();
        if (users.getUser(userName) == null) {
            return false;
        }
        currentUser = users.getUser(userName);
        if (currentUser.getPasscode().equals(passcode)){
            this.notifyObservers(currentUser);
            return true;
        }
        return false;
    }


    public void createUser(String username, String passcode) throws Exception {
        FileInputStream fis = new FileInputStream("userlist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserList users = (UserList) ois.readObject();
        User user = new User(username, passcode);
        users.add(user);
        FileOutputStream fos = new FileOutputStream("userlist.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }

    public void notifyObservers(User user) {
        for (CurrentUserObserver o: obs) {
            o.update(user);
        }
    }

    
}
