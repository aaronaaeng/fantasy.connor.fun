package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.AthleteStatistics;
import fun.connor.fantasy.Statistics.BatterStatistics;
import fun.connor.fantasy.Statistics.BowlerStatistics;
import org.testng.Assert;
import org.testng.annotations.Test;

import static fun.connor.fantasy.Athlete.AthleteType.BATTER;
import static fun.connor.fantasy.Athlete.AthleteType.BOWLER;

/**
 * Created by Aaron on 11/13/2018.
 */
public class AthleteFactoryTest {
    @Test
    public void testCreateAthlete_CreateBowler() throws Exception {
        AthleteFactory athleteFactory = new AthleteFactory();
        AthleteStatistics factoryResult = athleteFactory.getAthleteStatistics(BOWLER);
        Assert.assertTrue(factoryResult instanceof BowlerStatistics);
    }


    @Test
    public void testCreateAthlete_CreateBatter() throws Exception {
        AthleteFactory athleteFactory = new AthleteFactory();
        AthleteStatistics factoryResult = athleteFactory.getAthleteStatistics(BATTER);
        Assert.assertTrue(factoryResult instanceof BatterStatistics);
    }
}