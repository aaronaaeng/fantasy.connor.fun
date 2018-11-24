package fun.connor.fantasy.Statistics;

public class BatterData extends GameData {
    private Double war;
    private Double ba;
    private Double rbi;

    public BatterData()
    {
        this.war = 0.0;
        this.ba = 0.0;
        this.rbi = 0.0;
    }

    public BatterData(Double war, Double ba, Double rbi)
    {
        this.war = war;
        this.ba = ba;
        this.rbi = rbi;
    }

    Double getWar() { return this.war; }

    void updateWar(Double war)
    {
        this.war = this.recalculateAverage(this.war, war);
    }

    Double getBa() { return this.ba; }

    void updateBa(Double ba)
    {
        this.ba= this.recalculateAverage(this.ba, ba);
    }

    Double getRbi() { return this.rbi; }

    void updateRbi(Double rbi)
    {
        this.rbi = this.recalculateAverage(this.rbi, rbi);
    }
}
