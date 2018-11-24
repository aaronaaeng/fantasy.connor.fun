package fun.connor.fantasy.Statistics;

public class BatterStatistics implements AthleteStatistics {
    private BatterData batterData = new BatterData();
    private Double athleteValue = 0.0;

    public void addGame(GameData gameData)
    {
        BatterData batterData = (BatterData) gameData;
        this.batterData.updateWar(batterData.getWar());
        this.batterData.updateBa(batterData.getBa());
        this.batterData.updateRbi(batterData.getRbi());
        this.batterData.updateGamesPlayed();
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
