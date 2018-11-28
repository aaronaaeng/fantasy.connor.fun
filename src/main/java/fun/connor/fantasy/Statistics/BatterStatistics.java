package fun.connor.fantasy.Statistics;

/**
 * The BatterStatistics class serves as the statistics module for batters.  It provides the necessary logic to handle
 * batter data.
 */
public class BatterStatistics implements AthleteStatistics {
    /**
     * A reference to the batter data
     */
    private BatterData batterData = new BatterData();

    /**
     * The batter's value
     */
    private Double athleteValue = 0.0;

    /**
     * Adds a game's data to the athlete's data
     * @param gameData The object containing all relevant data
     */
    public void addGame(GameData gameData)
    {
        BatterData batterData = (BatterData) gameData;
        this.batterData.updateWar(batterData.getWar());
        this.batterData.updateBa(batterData.getBa());
        this.batterData.updateRbi(batterData.getRbi());
        this.batterData.updateGamesPlayed();
        this.updateAthleteValue();
    }

    /**
     * Returns the value of the batter
     * @return The value of the batter
     */
    public Double getAthleteValue()
    {
        return this.athleteValue;
    }

    /**
     * Recalculates the batter's value using its data
     */
    // Doing the actual math here is outside of the scope of this project. Teams of statisticians work on this
    private void updateAthleteValue()
    {
        this.athleteValue = (Math.random()*((1000)+1));
    }
}
