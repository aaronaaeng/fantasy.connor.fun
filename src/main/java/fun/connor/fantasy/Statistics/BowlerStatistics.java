package fun.connor.fantasy.Statistics;

/**
 * The BowlerStatistics class serves as the statistics module for bowlers.  It provides the necessary logic to handle
 * bowling data.
 */
public class BowlerStatistics implements AthleteStatistics {
    private BowlerData bowlerData = new BowlerData();
    private Double athleteValue = 0.0;

    /**
     * Adds a game's data to the bowler's dataset
     * @param gameData The data to be added
     */
    public void addGame(GameData gameData)
    {
        BowlerData bowlerData = (BowlerData) gameData;
        this.bowlerData.updateFirstBallAverage(bowlerData.getFirstBallAverage());
        this.bowlerData.updateMultiPinSpareAverage(bowlerData.getMultiPinSpareAverage());
        this.bowlerData.updateSinglePinSpareAverage(bowlerData.getSinglePinSpareAverage());
        this.bowlerData.updateSpeedAverage(bowlerData.getSpeedAverage());
        this.bowlerData.updateMatchWinLoss(bowlerData.getMatchWinLoss());
        this.bowlerData.updateGamesPlayed();
        this.updateAthleteValue();
    }

    /**
     * Returns the value of the bowler
     * @return The value of the bowler
     */
    public Double getAthleteValue()
    {
        return this.athleteValue;
    }

    /**
     * Updates the athlete's value with the newly updated dataset
     */
    // Doing the actual math well is definitely outside of the scope of this project
    private void updateAthleteValue()
    {
        this.athleteValue = (Math.random()*((1000)+1));
    }
}
