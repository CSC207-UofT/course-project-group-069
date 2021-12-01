package com.example.phase2.entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

