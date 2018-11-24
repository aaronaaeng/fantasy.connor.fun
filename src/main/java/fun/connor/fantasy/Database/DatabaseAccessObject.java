package fun.connor.fantasy.Database;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.League.League;
import fun.connor.fantasy.Team.Team;

import java.util.ArrayList;
import java.util.UUID;

public class DatabaseAccessObject {
    private final Database database = new Database();

    public DatabaseAccessObject()
    {
    }


    public void save(League league)
    {
        database.saveLeague(league.getLeagueId(), league);
    }

    public void save(Team team)
    {
        database.saveTeam(team.getTeamId(), team);
    }

    public void save(Athlete athlete)
    {
        database.saveAthlete(athlete.getAthleteID(), athlete);
    }

    public League loadLeague(UUID leagueId)
    {
        return database.loadLeague(leagueId);
    }

    public Team loadTeam(UUID teamId)
    {
        return database.loadTeam(teamId);
    }

    public Athlete loadAthlete(UUID athleteId)
    {
        return database.loadAthlete(athleteId);
    }

    public ArrayList<Athlete> loadAllAthletes()
    {
        return database.loadAllAthletes();
    }
}
