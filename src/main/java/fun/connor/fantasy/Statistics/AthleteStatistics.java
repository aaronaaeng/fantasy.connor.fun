package fun.connor.fantasy.Statistics;

/**
 * This defines the overall interface for all statistics modules.
 */
public interface AthleteStatistics {
    /**
     * Adds a game's data to the athlete's dataset
     * @param gameData The data to be added
     */
    void addGame(GameData gameData);

    /**
     * Returns the value of the athlete
     * @return The value of the athlete
     */
    Double getAthleteValue();
}
