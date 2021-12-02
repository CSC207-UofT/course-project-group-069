package com.example.phase2.use_case;

import com.example.phase2.entity.User;

public interface CurrentUserObserver {

    public void update(User user);
}
