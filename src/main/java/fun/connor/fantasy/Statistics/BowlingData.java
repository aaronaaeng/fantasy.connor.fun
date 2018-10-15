package fun.connor.fantasy.Statistics;

class BowlingData extends AbstractGameData {
    protected Double firstBallAverage;
    protected Double multiPinSpareAverage;
    protected Double singlePinSpareAverage;
    protected Double speedAverage;
    protected Double matchWinLoss;
    protected Integer gamesPlayed;

    public Double getFirstBallAverage()
    {
        return firstBallAverage;
    }

    public void setFirstBallAverage(Double firstBallAverage)
    {
        this.firstBallAverage = firstBallAverage;
    }

    public Double getMultiPinSpareAverage()
    {
        return multiPinSpareAverage;
    }

    public void setMultiPinSpareAverage(Double multiPinSpareAverage)
    {
        this.multiPinSpareAverage = multiPinSpareAverage;
    }

    public Double getSinglePinSpareAverage()
    {
        return singlePinSpareAverage;
    }

    public void setSinglePinSpareAverage(Double singlePinSpareAverage)
    {
        this.singlePinSpareAverage = singlePinSpareAverage;
    }

    public Double getSpeedAverage()
    {
        return speedAverage;
    }

    public void setSpeedAverage(Double speedAverage)
    {
        this.speedAverage = speedAverage;
    }

    public Double getMatchWinLoss()
    {
        return matchWinLoss;
    }

    public void setMatchWinLoss(Double matchWinLoss)
    {
        this.matchWinLoss = matchWinLoss;
    }

    public Integer getGamesPlayed()
    {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed)
    {
        this.gamesPlayed = gamesPlayed;
    }
}
