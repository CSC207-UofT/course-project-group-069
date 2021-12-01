package use_case;

import entity.UserList;

public interface ReadWriter {

     UserList getUserList() throws Exception;

     void saveUserList(UserList users) throws Exception;


}
