package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Statistics.BowlerStatistics;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;


/**
 * Created by Aaron on 9/29/2018.
 */
public class Bowler extends Athlete {
    Bowler(String bowlerData) {
        super(bowlerData, new BowlerStatistics());
    }
}
