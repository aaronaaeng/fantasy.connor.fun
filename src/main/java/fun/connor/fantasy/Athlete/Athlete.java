package fun.connor.fantasy.Athlete;


import fun.connor.fantasy.Statistics.AthleteStatistics;

import java.util.UUID;

public abstract class Athlete {
    private UUID athleteID;
    private AthleteName athleteName;
    private String athleteType;
    private AthleteStatistics athleteStatistics;

    Athlete(UUID athleteID, AthleteName athleteName, String athleteType, AthleteStatistics athleteStatistics)
    {
        this.athleteID = athleteID;
        this.athleteName = athleteName;
        this.athleteType = athleteType;
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

    public Double getAthleteValue()
    {
        return this.athleteStatistics.getAthleteValue();
    }
}
