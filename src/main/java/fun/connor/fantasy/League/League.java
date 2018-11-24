package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.AthleteType;
import fun.connor.fantasy.Budget.Budget;
import fun.connor.fantasy.Team.Team;
import fun.connor.fantasy.Team.TeamStanding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class League {
    private final UUID leagueId;
    private final AthleteType athleteType;
    private final Double teamBudget;
    private HashMap<UUID, Team> teamHashMap = new HashMap<>();

    League(UUID leagueId, AthleteType athleteType, Double teamBudget)
    {
        this.leagueId = leagueId;
        this.athleteType = athleteType;
        this.teamBudget = teamBudget;
    }

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

    AthleteType getAthleteType()
    {
        return this.athleteType;
    }

    Double getTeamBudget() { return this.teamBudget; }

    public UUID getLeagueId()
    {
        return this.leagueId;
    }
}
