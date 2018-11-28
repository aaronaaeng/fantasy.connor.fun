package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Athlete.AthleteType;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Statistics.BowlerStatistics;
import fun.connor.fantasy.Team.TeamStanding;

import java.util.*;

/**
 * The LeagueManager class provides a centralized way for other objects to interact with leagues.  It contains all
 * relevant methods to interact with individual leagues.
 */
public class LeagueManager {
    private final DatabaseAccessObject databaseAccessObject;
    private final HashMap<UUID, League> leagueHashMap = new HashMap<UUID, League>();

    /**
     * This constructor creates a new LeagueManager object.
     * @param databaseAccessObject A reference to the database access object
     */
    public LeagueManager(DatabaseAccessObject databaseAccessObject)
    {
        this.databaseAccessObject = databaseAccessObject;
    }

    /**
     * This method creates a league with the given parameters.  A flag is returned to indicate a successful creation.
     * @param athleteType The type of athlete in the league
     * @param teamBudget The starting budget for all teams
     * @return A flag indicating whether the league was successfully created
     */
    public Boolean createLeague(AthleteType athleteType, Double teamBudget)
    {
        UUID leagueId = UUID.randomUUID();
        League newLeague = new League(leagueId, athleteType, teamBudget);
        leagueHashMap.put(leagueId, newLeague);
        return true;
    }

    /**
     * This method returns the current standings of all teams within a league.
     * @param leagueId The ID of the league whose standings are being checked
     * @return A list of the team standings
     */
    public ArrayList<TeamStanding> getLeagueStandings(UUID leagueId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            return league.getLeagueStandings();
        }
        else
        {
            return new ArrayList<>();
        }
    }

    /**
     * Add a team to the desired league.  The league must exist.
     * @param leagueId The ID of the league receiving the new team
     * @param userName The username of the new team's owner
     * @param userId The ID of the new team's owner
     * @return A flag indicating wheher the add was successful.
     */
    public boolean addTeam(UUID leagueId, String userName, UUID userId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            return league.addTeam(userName, userId);
        }
        else
        {
            return false;
        }
    }

    /**
     * Handles the hiring of an athlete for a team within a league.
     * @param leagueId The ID of the league whose team is hiring
     * @param userId The ID of the team's owner
     * @param athleteId The ID of the athlete being hired
     * @return A flag indicating whether the hire was successful
     */
    public boolean hireAthlete(UUID leagueId, UUID userId, UUID athleteId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            Double athleteValue = getAthleteValue(athleteId);
            return league.hireAthlete(userId, athleteId, athleteValue);
        }
        else
        {
            return false;
        }
    }

    /**
     * Handles the firing of an athlete for a team within a league.
     * @param leagueId The ID of the league whose team is firing
     * @param userId The ID of the team's owner
     * @param athleteId The ID of the athlete being fired
     * @return A flag indicating whether the fire was successful
     */
    public boolean fireAthlete(UUID leagueId, UUID userId, UUID athleteId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            return league.fireAthlete(userId, athleteId);
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns a map of all leagues and their overview.
     * @return A map of all leagues and their overview.
     */
    public HashMap<UUID, LeagueDetails> getLeagues()
    {
        HashMap<UUID, LeagueDetails> leagueDetailsHashMap = new HashMap<>();
        for (Map.Entry<UUID, League> entry : this.leagueHashMap.entrySet())
        {
            League league = entry.getValue();
            LeagueDetails leagueDetails = new LeagueDetails(entry.getKey(), league.getAthleteType(), league.getTeamBudget());
            leagueDetailsHashMap.put(entry.getKey(), leagueDetails);
        }

        return leagueDetailsHashMap;
    }


    private Double getAthleteValue(UUID athleteId)
    {
        Athlete athlete = databaseAccessObject.loadAthlete(athleteId);
        return athlete.getAthleteValue();
    }
}
