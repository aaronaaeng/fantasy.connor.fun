package fun.connor.fantasy.Statistics;

public class BowlerStatistics implements GameAddition<BowlingData>, AthleteValuation {
    private BowlingData bowlingData = new BowlingData();
    private Double athleteValue = 0.0;

    public void addGame(BowlingData gameData)
    {
        this.bowlingData.updateFirstBallAverage(gameData.getFirstBallAverage());
        this.bowlingData.updateMultiPinSpareAverage(gameData.getMultiPinSpareAverage());
        this.bowlingData.updateSinglePinSpareAverage(gameData.getSinglePinSpareAverage());
        this.bowlingData.updateSpeedAverage(gameData.getSpeedAverage());
        this.bowlingData.updateMatchWinLoss(gameData.getMatchWinLoss());
        this.bowlingData.updateGamesPlayed();
        this.updateAthleteValue();
    }

    public Double getAthleteValue()
    {
        return this.athleteValue;
    }

    // Doing the actual math well is definitely outside of the scope of this project
    private void updateAthleteValue()
    {
        this.athleteValue = (Math.random()*((1000)+1));
    }
}
