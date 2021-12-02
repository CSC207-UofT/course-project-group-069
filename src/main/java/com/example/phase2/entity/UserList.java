package com.example.phase2.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserList implements Serializable {

    private final Map<String, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.getUserName(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

}
