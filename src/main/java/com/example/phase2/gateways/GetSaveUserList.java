package com.example.phase2.gateways;

import com.example.phase2.entity.UserList;

import java.io.*;

public class GetSaveUserList implements ReadWriter {

    @Override
    public UserList getUserList() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("userlist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (UserList) ois.readObject();
    }

    @Override
    public void saveUserList(UserList users) throws IOException {
        FileOutputStream fos = new FileOutputStream("userlist.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }
}
