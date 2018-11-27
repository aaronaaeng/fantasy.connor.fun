package fun.connor.fantasy.Auth;

import fun.connor.fantasy.Users.Account;
import fun.connor.fantasy.Users.User;

import java.util.UUID;

/**
 * The Authentication class is used to authenticate user login.
 * @author Aaron Aaeng
 * @version 1.0
 */
public class Authentication {
    /**
     * This method takes the username and hash of the password then returns the JWT for the user.
     * @param userName The user's username
     * @param passHash The hash of the user's password
     * @return The JSON Web Token for the user
     */
    public String authenticateUserLogin(String userName, String passHash)
    {
        User user;
        Account account;
        return "JWT";
    }

    /**
     * This method authenticates a user's access to a resource.
     * @param accessToken The user's JWT
     * @param resourceId The ID of the resource trying to be accessed
     * @return An indicator of whether the access was authorized
     */
    public boolean authorizeUserAccess(String accessToken, UUID resourceId)
    {
        return true;
    }
}
