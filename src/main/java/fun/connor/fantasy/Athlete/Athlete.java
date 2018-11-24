package fun.connor.fantasy.Athlete;


import fun.connor.fantasy.Statistics.AthleteStatistics;

import java.util.UUID;

public class Athlete {
    private final UUID athleteID;
    private final AthleteName athleteName;
    private final AthleteType athleteType;
    private AthleteStatistics athleteStatistics;

    public Athlete(UUID athleteID, AthleteName athleteName, AthleteType athleteType, AthleteStatistics athleteStatistics)
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

    public AthleteType getAthleteType() { return this.athleteType; }

    public void setAthleteStatistics(AthleteStatistics athleteStatistics)
    {
        this.athleteStatistics = athleteStatistics;
    }
}
