package fun.connor.fantasy.Athlete;


import fun.connor.fantasy.Statistics.AthleteStatistics;

import java.util.UUID;

/**
 * The Athlete class holds all relevant information for a draftable athlete.  There is a single object for all athlete
 * types.  Different types manifest in different statistics modules that can be changed at runtime.
 *
 * @author Aaron Aaeng
 * @version 1.0
 */
public class Athlete {
    /** The athlete's ID */
    private final UUID athleteID;
    /** The athlete's name */
    private final AthleteName athleteName;
    /** The athlete's type */
    private final AthleteType athleteType;
    /** The athlete's statistics module.  This is where its data and evaluation is held. */
    private AthleteStatistics athleteStatistics;

    /**
     * The base constructor for the athlete.  The statistics module is the only attribute that can be changed with a
     * setter.
     * @param athleteID The ID assigned to the athlete.
     * @param athleteName The AthleteName object representing the athlete's name.
     * @param athleteType The type of athlete. i.e. the sport the athlete plays.
     * @param athleteStatistics The statistics module for the athlete.  This should correspond with its type.
     */
    public Athlete(UUID athleteID, AthleteName athleteName, AthleteType athleteType, AthleteStatistics athleteStatistics)
    {
        this.athleteID = athleteID;
        this.athleteName = athleteName;
        this.athleteType = athleteType;
        this.athleteStatistics = athleteStatistics;
    }

    /**
     * Returns the athlete's ID.
     * @return The athlete's ID.
     */
    public UUID getAthleteID()
    {
        return this.athleteID;
    }

    /**
     * Returns the athlete's name object.
     * @return The athlete's name object.
     */
    public AthleteName getAthleteName()
    {
        return this.athleteName;
    }

    /**
     * Returns the athlete's value.
     * @return The athlete's value.
     */
    public Double getAthleteValue()
    {
        return this.athleteStatistics.getAthleteValue();
    }

    /**
     * Returns the athlete's type.
     * @return The athlete's type.
     */
    public AthleteType getAthleteType()
    {
        return this.athleteType;
    }

    /**
     * Sets the athlete's statistics module.  The data contained in the old module is lost.
     * @param athleteStatistics The new statistics module to be used.
     */
    public void setAthleteStatistics(AthleteStatistics athleteStatistics)
    {
        this.athleteStatistics = athleteStatistics;
    }
}
