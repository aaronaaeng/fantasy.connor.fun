package fun.connor.fantasy.Statistics;

/**
 * The GameData class provides the foundation for all types of sports data.  Since every sport has different relevant
 * statistics, this will have to be extended for each individual class as there is no way to truly standardize the
 * interface.
 */
abstract class GameData {
    /**
     * The number of games played
     */
    Integer gamesPlayed;

    /**
     * This method recaulculates the average for a given value
     * @param currentAverage The current value of the average
     * @param newValue The new value to be factored in
     * @return The new average for that value
     */
    Double recalculateAverage(Double currentAverage, Double newValue)
    {
        return ((currentAverage * this.gamesPlayed) + newValue) / (this.gamesPlayed + 1);
    }

    /**
     * This increments the number of games played
     */
    void updateGamesPlayed()
    {
        this.gamesPlayed += 1;
    }
}
