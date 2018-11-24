package fun.connor.fantasy.Statistics;

public class BowlerData extends GameData {
    private Double firstBallAverage;
    private Double multiPinSpareAverage;
    private Double singlePinSpareAverage;
    private Double speedAverage;
    private Double matchWinLoss;

    public BowlerData()
    {
        this.firstBallAverage = 0.0;
        this.multiPinSpareAverage = 0.0;
        this.singlePinSpareAverage = 0.0;
        this.speedAverage = 0.0;
        this.matchWinLoss = 0.0;
        this.gamesPlayed = 0;
    }

    public BowlerData(Double firstBallAverage, Double multiPinSpareAverage, Double singlePinSpareAverage,
                      Double speedAverage, Double matchWinLoss, Integer gamesPlayed)
    {
        this.firstBallAverage = firstBallAverage;
        this.multiPinSpareAverage = multiPinSpareAverage;
        this.singlePinSpareAverage = singlePinSpareAverage;
        this.speedAverage = speedAverage;
        this.matchWinLoss = matchWinLoss;
        this.gamesPlayed = gamesPlayed;
    }

    Double getFirstBallAverage()
    {
        return firstBallAverage;
    }

    void updateFirstBallAverage(Double firstBallAverage)
    {
        this.firstBallAverage = this.recalculateAverage(this.firstBallAverage, firstBallAverage);
    }

    Double getMultiPinSpareAverage()
    {
        return multiPinSpareAverage;
    }

    void updateMultiPinSpareAverage(Double multiPinSpareAverage)
    {
        this.multiPinSpareAverage = this.recalculateAverage(this.multiPinSpareAverage, multiPinSpareAverage);
    }

    Double getSinglePinSpareAverage()
    {
        return singlePinSpareAverage;
    }

    void updateSinglePinSpareAverage(Double singlePinSpareAverage)
    {
        this.singlePinSpareAverage = this.recalculateAverage(this.singlePinSpareAverage, singlePinSpareAverage);
    }

    Double getSpeedAverage()
    {
        return speedAverage;
    }

    void updateSpeedAverage(Double speedAverage)
    {
        this.speedAverage= this.recalculateAverage(this.speedAverage, speedAverage);
    }

    Double getMatchWinLoss()
    {
        return matchWinLoss;
    }

    void updateMatchWinLoss(Double matchWinLoss)
    {
        this.matchWinLoss= this.recalculateAverage(this.matchWinLoss, matchWinLoss);
    }
}
