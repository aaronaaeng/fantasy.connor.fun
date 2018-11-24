package fun.connor.fantasy.Database;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.League.League;
import fun.connor.fantasy.Team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

class Database {
    private HashMap<UUID, League> leagueMap= new HashMap<>();
    private HashMap<UUID, Team> teamMap = new HashMap<>();
    private HashMap<UUID, Athlete> athleteMap= new HashMap<>();

    void saveLeague(UUID LeagueId, League league)
    {
        leagueMap.put(LeagueId, league);
    }

    League loadLeague(UUID LeagueId)
    {
        return leagueMap.get(LeagueId);
    }

    void saveTeam(UUID teamId, Team team)
    {
        teamMap.put(teamId, team);
    }

    Team loadTeam(UUID teamId)
    {
        return teamMap.get(teamId);
    }

    void saveAthlete(UUID athleteId, Athlete athlete)
    {
        athleteMap.put(athleteId, athlete);
    }

    Athlete loadAthlete(UUID athleteId)
    {
        return athleteMap.get(athleteId);
    }

    ArrayList<Athlete> loadAllAthletes()
    {
        ArrayList<Athlete> allAthletes = new ArrayList<>();
        for (HashMap.Entry<UUID, Athlete> entry : athleteMap.entrySet())
        {
            Athlete athlete = entry.getValue();
            allAthletes.add(athlete);
        }
        return allAthletes;
    }


}
