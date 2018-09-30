package fun.connor.fantasy.Athlete;

import java.util.ArrayList;

/**
 * Created by Aaron on 9/29/2018.
 */
public interface AthleteDao {
    ArrayList<Athlete> getAllAthletes();
    void addAthlete(Athlete athlete);
    void updateAthlete(Athlete athlete);
}
