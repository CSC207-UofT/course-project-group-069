package com.example.phase2;

import com.example.phase2.entity.User;
import com.example.phase2.entity.UserList;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * This class reset the ser file if anything went wrong to it,
 * it creates a default user with username default and password 123 and
 * stores this user into the ser file
 */

public class UserListSerialization {
    public static void main(String[] args) throws Exception {

        UserList users = new UserList();
        User user = new User("default", "123");
        users.add(user);

        FileOutputStream fos = new FileOutputStream("userlist.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);

    }

}

