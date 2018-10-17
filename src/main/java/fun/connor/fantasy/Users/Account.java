package fun.connor.fantasy.Users;

import java.util.UUID;

public class Account {
    private final UUID userId;
    private final User user;
    public Account(UUID userId, User user)
    {
        this.userId = userId;
        this.user = user;
    }

    public UUID getUserId()
    {
        return this.userId;
    }

    public User getUser()
    {
        return this.user;
    }
}
