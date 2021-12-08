package com.example.phase2.gateways;

import com.example.phase2.entity.UserList;

import java.io.IOException;

public interface ReadWriter {

     UserList getUserList() throws IOException, ClassNotFoundException;

     void saveUserList(UserList users) throws IOException;


}
