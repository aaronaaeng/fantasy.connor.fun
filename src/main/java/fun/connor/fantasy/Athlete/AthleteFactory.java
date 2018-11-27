package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteStatistics;
import fun.connor.fantasy.Statistics.BatterStatistics;
import fun.connor.fantasy.Statistics.BowlerStatistics;
import fun.connor.fantasy.Statistics.NullStatistics;

import java.util.HashMap;
import java.util.Map;

import static fun.connor.fantasy.Athlete.AthleteType.BATTER;
import static fun.connor.fantasy.Athlete.AthleteType.BOWLER;

/**
 * The AthleteFactory class manages the runtime selection of statistics modules.
 *
 * @author Aaron Aaeng
 * @version 2.0
 */
public class AthleteFactory {
    /**
     *
     * @param athleteType The type of the athlete whose statistics module needs to be selected
     * @return A reference to the new
     */
    public AthleteStatistics getAthleteStatistics(AthleteType athleteType)
    {
        // 
        switch (athleteType)
        {
            case BOWLER: return new BowlerStatistics();
            case BATTER: return new BatterStatistics();
            default:
                return new NullStatistics();
        }
    }
}
