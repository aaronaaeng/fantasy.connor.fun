package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteStatistics;
import fun.connor.fantasy.Statistics.BowlerStatistics;

import java.util.UUID;

/**
 * Created by Aaron on 10/28/2018.
 */
public class Bowler extends Athlete {
    Bowler()
    {
        super(new UUID(0, 0), new AthleteName(), "bowler", new BowlerStatistics());
    }

    public Bowler(UUID athleteId, AthleteName athleteName)
    {
        super(athleteId, athleteName, "bowler", new BowlerStatistics());
    }
}
