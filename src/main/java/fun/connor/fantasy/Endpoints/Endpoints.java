package fun.connor.fantasy.Endpoints;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Athlete.AthleteFactory;
import fun.connor.fantasy.Auth.Authentication;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.League.LeagueManager;
import fun.connor.fantasy.Statistics.BowlerStatistics;

import java.util.HashMap;
import java.util.UUID;

import static spark.Spark.*;

public class Endpoints {
    private final Authentication authentication;
    private final DatabaseAccessObject databaseAccessObject;
    private final LeagueManager leagueManager;
    private final AthleteFactory athleteFactory;
    private final Gson gson;

    public Endpoints(Authentication authentication, DatabaseAccessObject databaseAccessObject,
                     LeagueManager leagueManager, AthleteFactory athleteFactory)
    {
        this.authentication = authentication;
        this.databaseAccessObject = databaseAccessObject;
        this.leagueManager = leagueManager;
        this.athleteFactory = athleteFactory;
        this.gson = new Gson();
    }

    public void Serve() {
        post("/login", (req, res) -> {
            String userName = req.queryParams("userName");
            String passHash = req.queryParams("passHash");
            return this.authentication.authenticateUserLogin(userName, passHash);
        });

        post("/create_league", (req, res) -> {
            Double teamBudget = Double.valueOf(req.queryParamOrDefault("teamBudget", "1000"));
            UUID leagueId = UUID.randomUUID();
            return this.leagueManager.createLeague(leagueId, teamBudget);
        });

        post("/add_team", (req, res) -> {
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            UUID userId = UUID.fromString(req.queryParams("userId"));
            return this.leagueManager.addTeam(leagueId, userId);
        });

        post("/create_athlete", (req, res) -> {
            String athleteData = req.queryParamOrDefault("athleteData", "{}");
            String athleteType = req.queryParamOrDefault("athleteType", "{}");
            Athlete athlete = gson.fromJson(athleteData, this.athleteFactory.createAthlete(athleteType).getClass());
            this.databaseAccessObject.saveAthlete(athlete);
            return "true";
        });

        post("/get_athlete", (req, res) -> {
            String athleteIDString = req.queryParams("athleteID");
            UUID athleteId = UUID.fromString(athleteIDString);
            return this.databaseAccessObject.loadAthlete(athleteId);
        });


        post("/hire_athlete", (req, res) -> {
            String accessToken = req.queryParams("accessToken");
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            UUID userId = UUID.fromString(req.queryParams("userId"));
            UUID athleteId = UUID.fromString(req.queryParams("athleteId"));

            if (this.authentication.authenticateUserAccess(accessToken, leagueId))
            {
                return this.leagueManager.hireAthlete(leagueId, userId, athleteId);
            }
            else
            {
                return false;
            }

        });

        post("/fire_athlete", (req, res) -> {
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            UUID userId = UUID.fromString(req.queryParams("userId"));
            UUID athleteId = UUID.fromString(req.queryParams("athleteId"));

            return this.leagueManager.fireAthlete(leagueId, userId, athleteId);
        });

        get("/get_league_standings", (req, res) -> {
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            return this.leagueManager.getLeagueStandings(leagueId);
        });
    }
}
