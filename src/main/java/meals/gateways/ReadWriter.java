package meals.gateways;

import meals.entity.UserList;

import java.io.IOException;

public interface ReadWriter {

     UserList getUserList() throws IOException, ClassNotFoundException;

     void saveUserList(UserList users) throws IOException;


}
