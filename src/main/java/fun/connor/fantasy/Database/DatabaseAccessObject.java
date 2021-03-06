package fun.connor.fantasy.Database;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.League.League;
import fun.connor.fantasy.Team.Team;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The DatabaseAccessObject class offers a simple API that abstracts out the actual functionality of the database and
 * its model.
 * @author Aaron Aaeng
 * @version 1.1
 */
public interface DatabaseAccessObject {
    /**
     * The save method writes the desired object to the database.  This method is overloaded to work with multiple
     * types.  This version takes a league.
     * @param league The league to be saved
     */
    void save(League league);

    /**
     * This is the same as {@link DatabaseAccessObject#save(League)} except it takes a Team.
     * @param team The team to be saved
     */
    void save(Team team);

    /**
     * This is the same as {@link DatabaseAccessObject#save(League)} except it takes an Athlete.
     * @param athlete The athlete to be saved
     */
    void save(Athlete athlete);

    /**
     * This method loads a league from the database with the given ID.
     * @param leagueId The ID of the league to be loaded
     * @return A reference to the loaded league
     */
    League loadLeague(UUID leagueId);

    /**
     * This method loads a teamfrom the database with the given ID.
     * @param teamId The ID of the team to be loaded
     * @return A reference to the loaded team
     */
    Team loadTeam(UUID teamId);

    /**
     * This method loads an athlete from the database with the given ID.
     * @param athleteId The ID of the athlete to be loaded
     * @return A reference to the loaded athlete
     */
    Athlete loadAthlete(UUID athleteId);

    /**
     * This method gets all valid athletes from the database.
     * @return A list of all valid athletes.
     */
    ArrayList<Athlete> loadAllAthletes();
}
