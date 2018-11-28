package fun.connor.fantasy.League;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

import static fun.connor.fantasy.Athlete.AthleteType.BOWLER;
import static org.testng.Assert.*;

/**
 * Tests the League's logic
 */
public class LeagueTest {
    @Test
    public void testGetLeagueStandings() throws Exception {
        League league = new League(UUID.randomUUID(), BOWLER, 50.00);
        league.addTeam("", UUID.randomUUID());
        league.addTeam("", UUID.randomUUID());
        league.getLeagueStandings();
    }

    @Test
    public void testAddTeam() throws Exception {
        League league = new League(UUID.randomUUID(), BOWLER, 50.00);
        UUID teamId = UUID.randomUUID();

        Boolean returnValue = league.addTeam("", teamId);
        Assert.assertTrue(returnValue);

        returnValue = league.addTeam("", teamId);
        Assert.assertFalse(returnValue);
    }

    @Test
    public void testHireAthlete() throws Exception {
        League league = new League(UUID.randomUUID(), BOWLER, 50.00);
        UUID userId = UUID.randomUUID();
        UUID athleteId = UUID.randomUUID();
        league.addTeam("", userId);
        Boolean returnValue = league.hireAthlete(userId, athleteId, 50.00);
        Assert.assertTrue(returnValue);

        returnValue = league.hireAthlete(userId, athleteId, 50.00);
        Assert.assertFalse(returnValue);

        returnValue = league.hireAthlete(userId, UUID.randomUUID(), 50.00);
        Assert.assertFalse(returnValue);
    }

    @Test
    public void testFireAthlete() throws Exception {
        League league = new League(UUID.randomUUID(), BOWLER, 50.00);
        UUID userId = UUID.randomUUID();
        UUID athleteId = UUID.randomUUID();
        league.addTeam("", userId);
        league.hireAthlete(userId, athleteId, 50.00);
        Boolean returnValue = league.fireAthlete(userId, UUID.randomUUID());
        Assert.assertFalse(returnValue);

        returnValue = league.fireAthlete(userId, athleteId);
        Assert.assertTrue(returnValue);
    }
}