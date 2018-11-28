package fun.connor.fantasy;

import fun.connor.fantasy.Athlete.AthleteFactory;
import fun.connor.fantasy.Auth.Authentication;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Database.DatabaseInit;
import fun.connor.fantasy.Endpoints.Endpoints;
import fun.connor.fantasy.League.LeagueManager;

/**
 * The Main class initializes the relevant aspects of the application and provides the core driver method.
 */
public class Main {
    /**
     * The main method for the application
     * @param args The arguments being passed to main
     */
    public static void main(String[] args)
    {
        Authentication authentication = new Authentication();
        DatabaseAccessObject databaseAccessObject = new DatabaseAccessObject();
        DatabaseInit.initializeAthletes(databaseAccessObject);
        LeagueManager leagueManager = new LeagueManager(databaseAccessObject);
        AthleteFactory athleteFactory = new AthleteFactory();
        Endpoints endpoints = new Endpoints(authentication, databaseAccessObject, leagueManager, athleteFactory);
        endpoints.Serve();
    }
}
