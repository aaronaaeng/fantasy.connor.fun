package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteValuation;
import fun.connor.fantasy.Statistics.GameAddition;

import java.util.UUID;

public class Athlete<T extends GameAddition & AthleteValuation> {
    private final UUID athleteID;
    private final AthleteName athleteName;
    private final T athleteStatistics;

    public Athlete()
    {
        this.athleteID = new UUID(0, 0);
        this.athleteName = new AthleteName("", "");
        this.athleteStatistics = null;
    }

    public Athlete(UUID athleteID, AthleteName athleteName, T athleteStatistics)
    {
        this.athleteID = athleteID;
        this.athleteName = athleteName;
        this.athleteStatistics = athleteStatistics;
    }

    public UUID getAthleteID()
    {
        return this.athleteID;
    }

    public AthleteName getAthleteName()
    {
        return this.athleteName;
    }

    public T getAthleteStatistics()
    {
        return this.athleteStatistics;
    }
}
