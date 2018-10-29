package fun.connor.fantasy.Statistics;

public class BowlerStatistics implements AthleteStatistics {
    private BowlerData bowlerData = new BowlerData();
    private Double athleteValue = 0.0;

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
