package fun.connor.fantasy.Team;

/**
 * The TeamStanding class is used to store an overview of a team. These are instantiated then immediately serialized to
 * JSON and sent to the front end.  This is done to reduce the amount of data being exposed to the frontend without
 * protection.
 */
public class TeamStanding {
    private final String name;
    private final Double score;

    /**
     * Creates a new team standing object with the given general team information
     * @param name The name of the team's owner
     * @param score The team's current score
     */
    public TeamStanding(String name, Double score)
    {
        this.name = name;
        this.score = score;
    }
}
