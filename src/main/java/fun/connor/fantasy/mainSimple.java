package fun.connor.fantasy;

import com.google.gson.Gson;
import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Athlete.AthleteName;
import fun.connor.fantasy.Statistics.BowlerStatistics;
import fun.connor.fantasy.Statistics.BowlingData;

import java.util.UUID;

public class mainSimple {
    public static void main(String[] args)
    {
        Athlete<BowlerStatistics> testAthlete = new Athlete<BowlerStatistics>(UUID.randomUUID(), new AthleteName("first", "last"), new BowlerStatistics());
        testAthlete.getAthleteStatistics().addGame(new BowlingData(1.4, 1.0, 0.1, 0.6, 0.6, 1));
        Gson gson = new Gson();
        System.out.println(gson.toJson(testAthlete));
    }
}
