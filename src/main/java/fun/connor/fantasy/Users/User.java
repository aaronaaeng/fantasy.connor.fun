package fun.connor.fantasy.Users;

import java.util.UUID;

public class User {
    private final UUID userId;
    private final Account account;
    public User(UUID userId, Account account)
    {
        this.userId = userId;
        this.account = account;
    }

    public UUID getUserId()
    {
        return userId;
    }

    public Account getAccount()
    {
        return account;
    }
}
