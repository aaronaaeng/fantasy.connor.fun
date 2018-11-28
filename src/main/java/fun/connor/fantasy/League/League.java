package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.AthleteType;
import fun.connor.fantasy.Budget.Budget;
import fun.connor.fantasy.Team.Team;
import fun.connor.fantasy.Team.TeamStanding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * The League class includes all of the relevant information for a league.  This includes references to teams and the
 * type of sport played in the league.
 */
public class League {
    private final UUID leagueId;
    private final AthleteType athleteType;
    private final Double teamBudget;
    private HashMap<UUID, Team> teamHashMap = new HashMap<>();

    /**
     * The League constructor takes the league's ID, the type of athlete, and the starting budget for all teams.
     * @param leagueId The ID of the league
     * @param athleteType The type of athlete to be drafted
     * @param teamBudget The starting team budget
     */
    League(UUID leagueId, AthleteType athleteType, Double teamBudget)
    {
        this.leagueId = leagueId;
        this.athleteType = athleteType;
        this.teamBudget = teamBudget;
    }

    /**
     * This method returns an unsorted list of all of the teams and their scores.
     * @return An unsorted list of objects containing the owner and score of each team in the league
     */
    ArrayList<TeamStanding> getLeagueStandings()
    {
        ArrayList<TeamStanding> leagueStandings = new ArrayList<>();
        for (HashMap.Entry<UUID, Team> entry : teamHashMap.entrySet())
        {
            Team team = entry.getValue();
            TeamStanding teamStanding = new TeamStanding(team.getOwner(), team.getTeamScore());
            leagueStandings.add(teamStanding);
        }
        return leagueStandings;
    }

    /**
     * This method adds a team to the league and returns a bool to indicate whether it was successfully added.
     * @param userName The user's username
     * @param userId The user's ID
     * @return A boolean indicating whether the team was added.  If the UUID was already associated with a team, the
     * method returns false.
     */
    boolean addTeam(String userName, UUID userId)
    {
        Budget newBudget = new Budget(teamBudget);
        Team newTeam = new Team(userName, newBudget);

        if (teamHashMap.containsKey(userId))
        {
            return false;
        }
        else
        {
            teamHashMap.put(userId, newTeam);
            return true;
        }
    }

    /**
     * This method allows athletes to be hired.  A boolean is returned to indicate whether the hiring took place
     * @param userId The user's ID
     * @param athleteId The athlete's ID
     * @param athleteValue The athlete's value
     * @return A boolean indicating whether the athlete was hired by the team
     */
    boolean hireAthlete(UUID userId, UUID athleteId, Double athleteValue)
    {
        if (teamHashMap.containsKey(userId))
        {
            Team playerTeam = teamHashMap.get(userId);
            return playerTeam.hireAthlete(athleteId, athleteValue);
        }
        else
        {
            return false;
        }
    }

    /**
     * This method is how athletes are fired by a team in the league.  A boolean is returned to indicate whether the
     * athlete was fired.
     * @param userId The user's ID
     * @param athleteId The athlete's ID
     * @return A boolean indicating whether the athlete was fired by the team
     */
    boolean fireAthlete(UUID userId, UUID athleteId)
    {
        if (teamHashMap.containsKey(userId))
        {
            Team playerTeam = teamHashMap.get(userId);
            return playerTeam.fireAthlete(athleteId);
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the type of the athlete used in the league
     * @return The type of the athlete used in the league
     */
    AthleteType getAthleteType()
    {
        return this.athleteType;
    }

    /**
     * Returns the starting budget for teams
     * @return The starting budget for teams
     */
    Double getTeamBudget() { return this.teamBudget; }

    public UUID getLeagueId()
    {
        return this.leagueId;
    }
}
