package fun.connor.fantasy.Statistics;

/**
 * Created by Aaron on 10/28/2018.
 */
abstract class GameData {
    Integer gamesPlayed;

    Double recalculateAverage(Double currentAverage, Double newValue)
    {
        return ((currentAverage * this.gamesPlayed) + newValue) / (this.gamesPlayed + 1);
    }

    void updateGamesPlayed()
    {
        this.gamesPlayed += 1;
    }
}
