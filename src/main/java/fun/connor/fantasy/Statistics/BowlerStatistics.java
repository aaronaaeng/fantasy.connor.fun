package fun.connor.fantasy.Statistics;

public class BowlerStatistics extends BowlingData implements GameAddition<BowlingData>, AthleteValuation {
    private Double athleteValue;

    public void addGame(BowlingData gameData)
    {
        this.updateAthleteValue();
    }

    public Double getAthleteValue()
    {
        return this.athleteValue;
    }

    private void updateAthleteValue()
    {

    }
}
