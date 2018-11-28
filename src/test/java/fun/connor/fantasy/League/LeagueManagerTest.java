package fun.connor.fantasy.League;

import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Database.DatabaseAccessObjectImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.UUID;

import static fun.connor.fantasy.Athlete.AthleteType.BOWLER;

/**
 * Tests the LeagueManager's logic
 */
public class LeagueManagerTest {
    @Test
    public void testCreateLeague() throws Exception {
        DatabaseAccessObject dao = new DatabaseAccessObjectImpl();
        LeagueManager leagueManager = new LeagueManager(dao);
        Boolean returnValue = leagueManager.createLeague(BOWLER, 50.00);
        Assert.assertTrue(returnValue);
    }

    @Test
    public void testGetLeagueStandings() throws Exception {
        DatabaseAccessObject dao = new DatabaseAccessObjectImpl();
        LeagueManager leagueManager = new LeagueManager(dao);
        leagueManager.createLeague(BOWLER, 100.00);
        HashMap<UUID, LeagueDetails> leagueMap = leagueManager.getLeagues();
        for (UUID leagueId : leagueMap.keySet())
        {
            leagueManager.getLeagueStandings(leagueId);
        }
    }

    @Test
    public void testAddTeam() throws Exception {
        DatabaseAccessObject dao = new DatabaseAccessObjectImpl();
        LeagueManager leagueManager = new LeagueManager(dao);
        UUID userId = UUID.randomUUID();
        leagueManager.createLeague(BOWLER, 50.00);

        HashMap<UUID, LeagueDetails> leagueMap = leagueManager.getLeagues();
        for (UUID leagueId : leagueMap.keySet())
        {
            Boolean returnValue = leagueManager.addTeam(leagueId, "test", userId);
            Assert.assertTrue(returnValue);
        }
    }

    @Test
    public void testHireAthlete() throws Exception {
        DatabaseAccessObject dao = new DatabaseAccessObjectImpl();
        LeagueManager leagueManager = new LeagueManager(dao);
        UUID userId = UUID.randomUUID();

        HashMap<UUID, LeagueDetails> leagueMap = leagueManager.getLeagues();
        for (UUID leagueId : leagueMap.keySet())
        {
            leagueManager.createLeague(BOWLER, 50.00);
            leagueManager.addTeam(leagueId, "test", userId);

            Boolean returnValue = leagueManager.hireAthlete(leagueId, userId, UUID.randomUUID());
            Assert.assertTrue(returnValue);

            returnValue = leagueManager.hireAthlete(leagueId, UUID.randomUUID(), UUID.randomUUID());
            Assert.assertFalse(returnValue);
        }
    }

    @Test
    public void testFireAthlete() throws Exception {
        DatabaseAccessObject dao = new DatabaseAccessObjectImpl();
        LeagueManager leagueManager = new LeagueManager(dao);
        UUID userId = UUID.randomUUID();
        UUID athleteId = UUID.randomUUID();

        HashMap<UUID, LeagueDetails> leagueMap = leagueManager.getLeagues();
        for (UUID leagueId : leagueMap.keySet()) {
            leagueManager.createLeague(BOWLER, 50.00);
            leagueManager.addTeam(leagueId, "test", userId);

            leagueManager.hireAthlete(leagueId, userId, athleteId);

            Boolean returnValue = leagueManager.fireAthlete(leagueId, userId, athleteId);
            Assert.assertTrue(returnValue);

            returnValue = leagueManager.fireAthlete(leagueId, userId, athleteId);
            Assert.assertFalse(returnValue);
        }
    }
}