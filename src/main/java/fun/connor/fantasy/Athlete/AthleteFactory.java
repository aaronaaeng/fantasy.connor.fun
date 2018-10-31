package fun.connor.fantasy.Athlete;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron on 10/28/2018.
 */
public class AthleteFactory {
    private Map<String, Athlete> athleteMap = new HashMap<String, Athlete>() {
        {
            put("bowler", new Bowler());
        }
    };
    public Athlete createAthlete(String athleteType)
    {
        return athleteMap.get(athleteType);
    }
}
