package fun.connor.fantasy.Athlete;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aaron on 11/13/2018.
 */
public class AthleteFactoryTest {
    @Test
    public void testCreateAthlete_CreatesBowler() throws Exception {
        AthleteFactory athleteFactory = new AthleteFactory();
        Athlete factoryResult = athleteFactory.createAthlete("bowler");
        Assert.assertTrue(factoryResult instanceof Bowler);
    }
}