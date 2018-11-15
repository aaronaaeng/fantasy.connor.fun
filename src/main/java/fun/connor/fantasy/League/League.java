package fun.connor.fantasy.League;

import fun.connor.fantasy.Budget.Budget;
import fun.connor.fantasy.Team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

class League {
    private final UUID leagueId;
    private final String athleteType;
    private final Double teamBudget;
    private HashMap<UUID, Team> teamHashMap = new HashMap<>();

    League(UUID leagueId, String athleteType, Double teamBudget)
    {
        this.leagueId = leagueId;
        this.athleteType = athleteType;
        this.teamBudget = teamBudget;
    }

    HashMap<UUID, Double> getLeagueStandings()
    {
        HashMap<UUID, Double> standingsMap = new HashMap<>();
        for (HashMap.Entry<UUID, Team> entry : teamHashMap.entrySet())
        {
            standingsMap.put(entry.getKey(), entry.getValue().getTeamScore());
        }
        return standingsMap;
    }

    boolean addTeam(UUID userId)
    {
        Budget newBudget = new Budget(teamBudget);
        Team newTeam = new Team(newBudget);

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

    String getAthleteType()
    {
        return this.athleteType;
    }

    Double getTeamBudget() { return this.teamBudget; }
}
