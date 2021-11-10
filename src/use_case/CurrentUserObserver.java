package use_case;

import entity.User;

public interface CurrentUserObserver {

    public void update(User user);
}
