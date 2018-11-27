package fun.connor.fantasy.Endpoints;

import com.google.gson.Gson;
import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Athlete.AthleteFactory;
import fun.connor.fantasy.Athlete.AthleteType;
import fun.connor.fantasy.Auth.Authentication;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.League.LeagueManager;
import fun.connor.fantasy.Statistics.AthleteStatistics;

import java.util.UUID;

import static fun.connor.fantasy.Endpoints.JsonUtils.json;
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
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        post("/login", (req, res) -> {
            String userName = req.queryParams("userName");
            String passHash = req.queryParams("passHash");
            return this.authentication.authenticateUserLogin(userName, passHash);
        }, json());

        post("/create_league", (req, res) -> {
            Double teamBudget = Double.valueOf(req.queryParamOrDefault("teamBudget", "1000"));
            String athleteTypeString = req.queryParamOrDefault("athleteType", "BOWLER");
            AthleteType athleteType = AthleteType.valueOf(athleteTypeString);
            return this.leagueManager.createLeague(athleteType, teamBudget);
        }, json());

        post("/add_team", (req, res) -> {
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            String userName= req.queryParams("userName");
            UUID userId = UUID.fromString(req.queryParams("userId"));
            return this.leagueManager.addTeam(leagueId, userName, userId);
        }, json());

        post("/create_athlete", (req, res) -> {
            String athleteData = req.queryParamOrDefault("athleteData", "{}");
            String athleteTypeString = req.queryParamOrDefault("athleteType", "{}");
            AthleteType athleteType = AthleteType.valueOf(athleteTypeString);
            AthleteStatistics athleteStatistics = this.athleteFactory.getAthleteStatistics(athleteType);
            Athlete athlete = gson.fromJson(athleteData, Athlete.class);
            athlete.setAthleteStatistics(athleteStatistics);
            this.databaseAccessObject.save(athlete);
            return true;
        }, json());

        get("/get_athlete", (req, res) -> {
            String athleteIDString =  req.queryParams("athleteID");
            UUID athleteId = UUID.fromString(athleteIDString);
            return this.databaseAccessObject.loadAthlete(athleteId);
        }, json());

        get("/get_all_athletes", (req, res) -> {
            return this.databaseAccessObject.loadAllAthletes();
        }, json());

        post("/hire_athlete", (req, res) -> {
            String accessToken = req.queryParams("accessToken");
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            UUID userId = UUID.fromString(req.queryParams("userId"));
            UUID athleteId = UUID.fromString(req.queryParams("athleteId"));

            return this.authentication.authenticateUserAccess(accessToken, leagueId) &&
                    this.leagueManager.hireAthlete(leagueId, userId, athleteId);
        }, json());

        post("/fire_athlete", (req, res) -> {
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            UUID userId = UUID.fromString(req.queryParams("userId"));
            UUID athleteId = UUID.fromString(req.queryParams("athleteId"));

            return this.leagueManager.fireAthlete(leagueId, userId, athleteId);
        }, json());

        get("/get_league_standings", (req, res) -> {
            UUID leagueId = UUID.fromString(req.queryParams("leagueId"));
            return this.leagueManager.getLeagueStandings(leagueId);
        }, json());

        get("/get_leagues", (req, res) -> {
            return this.leagueManager.getLeagues().values();//.toArray()[0];
        }, json());
    }
}
