package fun.connor.fantasy;

import fun.connor.fantasy.Athlete.AthleteFactory;
import fun.connor.fantasy.Auth.Authentication;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Endpoints.Endpoints;
import fun.connor.fantasy.League.LeagueManager;

public class Main {
    public static void main(String[] args)
    {
        Authentication authentication = new Authentication();
        DatabaseAccessObject databaseAccessObject = new DatabaseAccessObject();
        LeagueManager leagueManager = new LeagueManager(databaseAccessObject);
        AthleteFactory athleteFactory = new AthleteFactory();
        Endpoints endpoints = new Endpoints(authentication, databaseAccessObject, leagueManager, athleteFactory);
        endpoints.Serve();
    }
}
