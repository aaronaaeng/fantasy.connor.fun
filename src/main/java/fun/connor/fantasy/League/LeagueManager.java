package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Statistics.BowlerStatistics;

import java.util.*;

public class LeagueManager {
    private final DatabaseAccessObject databaseAccessObject;
    private final HashMap<UUID, League> leagueHashMap = new HashMap<UUID, League>();

    public LeagueManager(DatabaseAccessObject databaseAccessObject)
    {
        this.databaseAccessObject = databaseAccessObject;
    }

    public Boolean createLeague(String athleteType, Double teamBudget)
    {
        UUID leagueId = UUID.randomUUID();
        League newLeague = new League(leagueId, athleteType, teamBudget);
        leagueHashMap.put(leagueId, newLeague);
        return true;
    }

    public HashMap<UUID, Double> getLeagueStandings(UUID leagueId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            return league.getLeagueStandings();
        }
        else
        {
            return new HashMap<>();
        }
    }

    public boolean addTeam(UUID leagueId, UUID userId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            return league.addTeam(userId);
        }
        else
        {
            return false;
        }
    }

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
//        Athlete<BowlerStatistics> athlete = this.databaseAccessObject.loadAthlete(athleteId);
//        return athlete.getAthleteStatistics().getAthleteValue();
        return 0.0;
    }
}
