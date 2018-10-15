package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteValuation;
import fun.connor.fantasy.Statistics.GameAddition;
import fun.connor.fantasy.Statistics.AbstractGameData;

import java.util.UUID;

public class Athlete<AthleteStatistics extends GameAddition & AthleteValuation, GameData> {
    private final UUID athleteID;
    private final AthleteName athleteName;
    private final AthleteStatistics athleteStatistics;

    Athlete(UUID athleteID, AthleteName athleteName, AthleteStatistics athleteStatistics)
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

    public void addGame(GameData gameData)
    {
        this.athleteStatistics.addGame(gameData);
    }
}
