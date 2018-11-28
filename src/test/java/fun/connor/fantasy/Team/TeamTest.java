package fun.connor.fantasy.Team;

import fun.connor.fantasy.Budget.Budget;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Tests the Team object to ensure the hire and fire methods work properly
 */
public class TeamTest {
    @Test
    public void testHireAthlete() throws Exception {
        Team team = new Team("", new Budget(50.00));
        UUID athleteId = UUID.randomUUID();
        Boolean returnValue = team.hireAthlete(athleteId, 50.00);
        Assert.assertTrue(returnValue);

        returnValue = team.hireAthlete(athleteId, 0.0);
        Assert.assertFalse(returnValue);

        returnValue = team.hireAthlete(UUID.randomUUID(), 50.00);
        Assert.assertFalse(returnValue);
    }

    @Test
    public void testFireAthlete() throws Exception {
        Team team = new Team("", new Budget(50.00));
        UUID athleteId = UUID.randomUUID();
        team.hireAthlete(athleteId, 50.00);
        Boolean returnValue = team.fireAthlete(UUID.randomUUID());
        Assert.assertFalse(returnValue);

        returnValue = team.fireAthlete(athleteId);
        Assert.assertTrue(returnValue);
    }

}