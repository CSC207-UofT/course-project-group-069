package gateways;

import entity.UserList;
import use_case.ReadWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GetSaveUserList implements ReadWriter {

    @Override
    public UserList getUserList() throws Exception {
        FileInputStream fis = new FileInputStream("userlist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserList users = (UserList) ois.readObject();
        return users;
    }

    @Override
    public void saveUserList(UserList users) throws Exception {
        FileOutputStream fos = new FileOutputStream("userlist.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }
}
