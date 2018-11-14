package fun.connor.fantasy.League;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by Aaron on 11/13/2018.
 */
public class LeagueTest {
    @Test
    public void testGetLeagueStandings() throws Exception {
        League league = new League(UUID.randomUUID(), 100.00);
        league.addTeam(UUID.randomUUID());
        league.addTeam(UUID.randomUUID());
        Assert.assertTrue(false);
        System.out.println(league.getLeagueStandings());
    }

    @Test
    public void testAddTeam() throws Exception {
        League league = new League(UUID.randomUUID(), 100.00);
        Boolean returnValue = league.addTeam(UUID.randomUUID());
        Assert.assertTrue(false);
    }

    @Test
    public void testHireAthlete() throws Exception {
        Assert.assertTrue(false);
    }

    @Test
    public void testFireAthlete() throws Exception {
        Assert.assertTrue(false);
    }

}