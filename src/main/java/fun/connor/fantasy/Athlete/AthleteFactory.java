package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteStatistics;
import fun.connor.fantasy.Statistics.BatterStatistics;
import fun.connor.fantasy.Statistics.BowlerStatistics;
import fun.connor.fantasy.Statistics.NullStatistics;

import java.util.HashMap;
import java.util.Map;

import static fun.connor.fantasy.Athlete.AthleteType.BOWLER;

/**
 * Created by Aaron on 10/28/2018.
 */
public class AthleteFactory {
    private Map<AthleteType, AthleteStatistics> athleteMap = new HashMap<AthleteType, AthleteStatistics>() {
        {
            put(BOWLER, new BowlerStatistics());
        }
    };

    public AthleteStatistics getAthleteStatistics(AthleteType athleteType)
    {
        switch (athleteType)
        {
            case BOWLER: return new BowlerStatistics();
            case BATTER: return new BatterStatistics();
            default:
                return new NullStatistics();
        }
    }
}
