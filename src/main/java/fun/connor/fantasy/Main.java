package fun.connor.fantasy;

import fun.connor.fantasy.Authentication.Authentication;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Endpoints.Endpoints;
import fun.connor.fantasy.League.LeagueManager;

public class Main {
    public static void main(String[] args)
    {
        Authentication authentication = new Authentication();
        DatabaseAccessObject databaseAccessObject = new DatabaseAccessObject();
        LeagueManager leagueManager = new LeagueManager(databaseAccessObject);
        Endpoints endpoints = new Endpoints(authentication, databaseAccessObject, leagueManager);
        endpoints.Serve();
    }
}
