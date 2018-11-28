package fun.connor.fantasy.Statistics;

/**
 * This null object is selected by the {@link fun.connor.fantasy.Athlete.AthleteFactory} when the input
 * {@link fun.connor.fantasy.Athlete.AthleteType} is unknown.  This is done to protect against runtime errors caused
 * by corrupted data coming from the frontend.
 */
public class NullStatistics implements AthleteStatistics {
    /**
     * This method does nothing and only exists to prevent runtime errors
     * @param gameData The data to be added
     */
    public void addGame( GameData gameData) { }

    /**
     * This method always returns -1 to indicate that it is the null object
     * @return -1
     */
    public Double getAthleteValue() { return -1.0; }
}
