package fun.connor.fantasy.Statistics;

/**
 * The BowlingData class extends GameData and adds methods and attributes specific to the statistics used in bowling.
 */
public class BowlerData extends GameData {
    private Double firstBallAverage;
    private Double multiPinSpareAverage;
    private Double singlePinSpareAverage;
    private Double speedAverage;
    private Double matchWinLoss;

    /**
     * The default constructor creates a new BowlerData instance with all values at 0.
     */
    public BowlerData()
    {
        this.firstBallAverage = 0.0;
        this.multiPinSpareAverage = 0.0;
        this.singlePinSpareAverage = 0.0;
        this.speedAverage = 0.0;
        this.matchWinLoss = 0.0;
        this.gamesPlayed = 0;
    }

    /**
     * This constructor allows for the values to be initialized to specific values
     * @param firstBallAverage The athlete's first ball average
     * @param multiPinSpareAverage The athlete's multi pin spare average
     * @param singlePinSpareAverage The athlete's single pin spare average
     * @param speedAverage The athlete's speed average
     * @param matchWinLoss The athlete's match win loss
     * @param gamesPlayed The athlete's games played
     */
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

    /**
     * Returns the athlete's first ball average
     * @return The athlete's first ball average
     */
    Double getFirstBallAverage()
    {
        return firstBallAverage;
    }

    /**
     * Recalculates the athlete's first ball average given a new value
     * @param firstBallAverage The new first ball average datapoint
     */
    void updateFirstBallAverage(Double firstBallAverage)
    {
        this.firstBallAverage = this.recalculateAverage(this.firstBallAverage, firstBallAverage);
    }

    /**
     * Returns the athlete's multi pin spare average
     * @return The athlete's multi pin spare average
     */
    Double getMultiPinSpareAverage()
    {
        return multiPinSpareAverage;
    }

    /**
     * Recalculates the athlete's multi pin spare average given a new value
     * @param multiPinSpareAverage The new multi pin spare average datapoint
     */
    void updateMultiPinSpareAverage(Double multiPinSpareAverage)
    {
        this.multiPinSpareAverage = this.recalculateAverage(this.multiPinSpareAverage, multiPinSpareAverage);
    }

    /**
     * Returns the athlete's single pin spare average
     * @return The athlete's single pin spare average
     */
    Double getSinglePinSpareAverage()
    {
        return singlePinSpareAverage;
    }

    /**
     * Recalculates the athlete's single pin spare average given a new value
     * @param singlePinSpareAverage The new single pin spare average datapoint
     */
    void updateSinglePinSpareAverage(Double singlePinSpareAverage)
    {
        this.singlePinSpareAverage = this.recalculateAverage(this.singlePinSpareAverage, singlePinSpareAverage);
    }

    /**
     * Returns the athlete's speed average
     * @return The athlete's speed average
     */
    Double getSpeedAverage()
    {
        return speedAverage;
    }

    /**
     * Recalculates the athlete's speed average given a new value
     * @param speedAverage The new speed average datapoint
     */
    void updateSpeedAverage(Double speedAverage)
    {
        this.speedAverage= this.recalculateAverage(this.speedAverage, speedAverage);
    }

    /**
     * Returns the athlete's match with loss
     * @return The athlete's match with loss
     */
    Double getMatchWinLoss()
    {
        return matchWinLoss;
    }

    /**
     * Recalculates the athlete match winrate
     * @param matchWinLoss The new winrate datapoint
     */
    void updateMatchWinLoss(Double matchWinLoss)
    {
        this.matchWinLoss= this.recalculateAverage(this.matchWinLoss, matchWinLoss);
    }
}
