package meals.use_case;

import meals.entity.User;

public interface CurrentUserObserver {

    public void update(User user);
}
