package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Statistics.BowlerStatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class LeagueManager {
    private final DatabaseAccessObject databaseAccessObject;
    private final HashMap<UUID, League> leagueHashMap = new HashMap<UUID, League>();

    public LeagueManager(DatabaseAccessObject databaseAccessObject)
    {
        this.databaseAccessObject = databaseAccessObject;
    }

    public Boolean createLeague(Double teamBudget)
    {
        UUID leagueId = UUID.randomUUID();
        League newLeague = new League(leagueId, teamBudget);
        leagueHashMap.put(leagueId, newLeague);
        return true;
    }

    public ArrayList<Double> getLeagueStandings(UUID leagueId)
    {
        if (leagueHashMap.containsKey(leagueId))
        {
            League league = leagueHashMap.get(leagueId);
            return league.getLeagueStandings();
        }
        else
        {
            return new ArrayList<Double>();
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
            Double athleteValue = getAthleteValue(athleteId);
            return league.fireAthlete(userId, athleteId, athleteValue);
        }
        else
        {
            return false;
        }
    }

    private Double getAthleteValue(UUID athleteId)
    {
//        Athlete<BowlerStatistics> athlete = this.databaseAccessObject.loadAthlete(athleteId);
//        return athlete.getAthleteStatistics().getAthleteValue();
        return 0.0;
    }
}
