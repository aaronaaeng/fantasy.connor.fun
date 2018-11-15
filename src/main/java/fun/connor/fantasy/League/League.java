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

    ArrayList<Double> getLeagueStandings()
    {
        ArrayList<Double> standingsList = new ArrayList<>();
        for (HashMap.Entry<UUID, Team> entry : teamHashMap.entrySet())
        {
            standingsList.add(entry.getValue().getTeamScore());
        }
        return standingsList;
    }

    boolean addTeam(UUID userId)
    {
        Budget newBudget = new Budget(teamBudget);
        Team newTeam = new Team(newBudget);
        teamHashMap.putIfAbsent(userId, newTeam);
        return true;
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


}
