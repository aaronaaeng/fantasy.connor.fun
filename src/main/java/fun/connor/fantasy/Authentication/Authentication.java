package fun.connor.fantasy.Authentication;

import fun.connor.fantasy.Users.Account;
import fun.connor.fantasy.Users.User;

import java.util.UUID;

public class Authentication {
    public String authenticateUserLogin(String userName, String passHash)
    {
        User user;
        Account account;
        return "JWT";
    }

    public boolean authenticateUserAccess(String accessToken, UUID resourceId)
    {
        return false;
    }
}
