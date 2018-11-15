package fun.connor.fantasy.Statistics;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Aaron on 11/14/2018.
 */
public class BowlerDataTest {
    @Test
    public void testUpdateFirstBallAverage() throws Exception {
        BowlerData bowlerData = new BowlerData();
        bowlerData.updateFirstBallAverage(1.0);
        bowlerData.updateGamesPlayed();
        bowlerData.updateFirstBallAverage(11.0);

        Double newAverage = bowlerData.getFirstBallAverage();

        Assert.assertEquals(6.0, newAverage);
    }

    @Test
    public void testUpdateMultiPinSpareAverage() throws Exception {
        BowlerData bowlerData = new BowlerData();
        bowlerData.updateFirstBallAverage(1.0);
        bowlerData.updateGamesPlayed();
        bowlerData.updateFirstBallAverage(11.0);

        Double newAverage = bowlerData.getFirstBallAverage();

        Assert.assertEquals(6.0, newAverage);
    }

    @Test
    public void testUpdateSinglePinSpareAverage() throws Exception {
        BowlerData bowlerData = new BowlerData();
        bowlerData.updateSinglePinSpareAverage(1.0);
        bowlerData.updateGamesPlayed();
        bowlerData.updateSinglePinSpareAverage(11.0);

        Double newAverage = bowlerData.getSinglePinSpareAverage();

        Assert.assertEquals(6.0, newAverage);
    }

    @Test
    public void testUpdateSpeedAverage() throws Exception {
        BowlerData bowlerData = new BowlerData();
        bowlerData.updateSpeedAverage(1.0);
        bowlerData.updateGamesPlayed();
        bowlerData.updateSpeedAverage(11.0);

        Double newAverage = bowlerData.getSpeedAverage();

        Assert.assertEquals(6.0, newAverage);
    }

    @Test
    public void testUpdateMatchWinLoss() throws Exception {
        BowlerData bowlerData = new BowlerData();
        bowlerData.updateMatchWinLoss(1.0);
        bowlerData.updateGamesPlayed();
        bowlerData.updateMatchWinLoss(0.0);

        Double newAverage = bowlerData.getMatchWinLoss();

        Assert.assertEquals(0.5, newAverage);
    }

}