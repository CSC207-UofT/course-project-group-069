package com.example.phase2.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a collection of users that uses this program
 */

public class UserList implements Serializable {

    private final Map<String, User> users = new HashMap<>();

    /**
     * Add a new user to the collection of users that uses this program
     * @param user A user object representing a user of the program
     */
    public void add(User user) {
        users.put(user.getUserName(), user);
    }

    /**
     * get a particular user in the collection of users that uses this program given the username
     * @param username a string representation of a user's username
     * @return A user object representing a user of the program
     */
    public User getUser(String username) {
        return users.get(username);
    }

}
