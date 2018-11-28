package fun.connor.fantasy.Statistics;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Tests the BowlerStatistics object
 */
public class BowlerStatisticsTest {
    @Test
    public void testAddGame() throws Exception {
        BowlerStatistics bowlerStatistics = new BowlerStatistics();
        BowlerData bowlerData = new BowlerData();
        bowlerData.updateFirstBallAverage(1.0);
        bowlerData.updateMultiPinSpareAverage(1.0);
        bowlerData.updateSinglePinSpareAverage(1.0);
        bowlerData.updateSpeedAverage(1.0);
        bowlerData.updateMatchWinLoss(1.0);

        bowlerStatistics.addGame(bowlerData);
    }

}