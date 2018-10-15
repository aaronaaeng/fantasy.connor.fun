package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteValuation;
import fun.connor.fantasy.Statistics.GameAddition;

import java.util.UUID;

public class Athlete<AthleteStatistics extends GameAddition & AthleteValuation> {
    private final UUID athleteID;
    private final AthleteName athleteName;
    private final AthleteStatistics athleteStatistics;

    public Athlete(UUID athleteID, AthleteName athleteName, AthleteStatistics athleteStatistics)
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

    public AthleteStatistics getAthleteStatistics()
    {
        return this.athleteStatistics;
    }
}
