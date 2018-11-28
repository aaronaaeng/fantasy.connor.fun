package fun.connor.fantasy.Statistics;

/**
 * The BatterData class extends GameData and adds methods and attributes specific to the statistics used in baseball.
 */
public class BatterData extends GameData {
    /**
     * The batter's wins above replacement
     */
    private Double war;

    /**
     * The batter's batting average
     */
    private Double ba;

    /**
     * The batter's runs batted in
     */
    private Double rbi;

    /**
     * The default constructor creates a new BatterData instance with all values at 0.
     */
    public BatterData()
    {
        this.war = 0.0;
        this.ba = 0.0;
        this.rbi = 0.0;
    }

    /**
     * This constructor allows for the specification of default values.
     * @param war The player's war
     * @param ba The player's ba
     * @param rbi The player's rbi
     */
    public BatterData(Double war, Double ba, Double rbi)
    {
        this.war = war;
        this.ba = ba;
        this.rbi = rbi;
    }

    /**
     * Returns the batter's wins above replacement
     * @return The batter's wins above replacement
     */
    Double getWar()
    {
        return this.war;
    }

    /**
     * Update's the batter's war with the new value.  This is used to recalculate the mean war for the player.
     * @param war The batter's new war datapoint
     */
    void updateWar(Double war)
    {
        this.war = this.recalculateAverage(this.war, war);
    }

    /**
     * Returns the batter's batting average
     * @return The batter's batting average
     */
    Double getBa()
    {
        return this.ba;
    }

    /**
     * Update's the batter's batting average with the new value.  This is used to recalculate the mean BA for the
     * player.
     * @param ba The batter's new ba datapoint
     */
    void updateBa(Double ba)
    {
        this.ba= this.recalculateAverage(this.ba, ba);
    }

    /**
     * Returns the runs batted in for the batter
     * @return The runs batted in for the batter
     */
    Double getRbi()
    {
        return this.rbi;
    }
    /**
     * Update's the batter's rbi with the new value.  This is used to recalculate the mean rbi for the player.
     * @param rbi The batter's new rbidatapoint
     */
    void updateRbi(Double rbi)
    {
        this.rbi = this.recalculateAverage(this.rbi, rbi);
    }
}
