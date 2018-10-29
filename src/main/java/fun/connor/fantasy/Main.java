package fun.connor.fantasy;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Athlete.AthleteFactory;
import fun.connor.fantasy.Auth.Authentication;
import fun.connor.fantasy.Database.DatabaseAccessObject;
import fun.connor.fantasy.Endpoints.Endpoints;
import fun.connor.fantasy.League.LeagueManager;

public class Main {
    public static void main(String[] args)
    {
        AthleteFactory factory = new AthleteFactory();
        Athlete athlete = factory.createAthlete("BOWLER");
//        athlete.
    }
}
