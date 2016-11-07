package in.varunrana.codeassignment.DataHandlers;

import java.io.Serializable;

/**
 *  Purpose of implementing the handler is to provide a generic way to share
 *  the User details among different Modules.
 *
 *  This will also help when we authenticate the user credentials from the server and
 *  in case if it require to fetch a lot of new fields related to user details like
 *  userId, address, so on.
 *
 *  Using the handler we can add them and access them easily through out the application.
 *
 * Created by vr3v3n on 07/11/16.
 */
public class UserInfoHandler implements Serializable{

    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
