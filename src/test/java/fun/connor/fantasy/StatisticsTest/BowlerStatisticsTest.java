package fun.connor.fantasy.StatisticsTest;

import fun.connor.fantasy.Statistics.BowlerStatistics;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aaron on 9/29/2018.
 */
public class BowlerStatisticsTest {
    @Test
    public void addGame_ImproperInput()
    {
        final Boolean expected = false;
        BowlerStatistics bowlerStatistics = new BowlerStatistics();

        final Boolean actual = bowlerStatistics.addGame("Incorrect");

        Assert.assertEquals(actual, expected);
    }
}
