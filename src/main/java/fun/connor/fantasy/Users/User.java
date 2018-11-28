package fun.connor.fantasy.Users;

import java.util.UUID;

public class User {
    /**
     * The user's ID
     */
    private final UUID userId;

    /**
     * Creates a new user object given its ID
     * @param userId The user's ID
     */
    public User(UUID userId)
    {
        this.userId = userId;
    }

    /**
     * Returns the user's ID
     * @return The user's ID
     */
    public UUID getUserId()
    {
        return userId;
    }
}
