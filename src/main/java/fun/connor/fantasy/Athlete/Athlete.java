package fun.connor.fantasy.Athlete;

import fun.connor.fantasy.Statistics.Statistics;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

/**
 * Created by Aaron on 9/29/2018.
 */
abstract public class Athlete {
    private String name;
    private String description;
    private Statistics statistics;

    Athlete(String bowlerData, Statistics statsModule) {
        this.statistics = statsModule;

        JsonReader jsonReader = Json.createReader(new StringReader(bowlerData));
        JsonObject dataObject = jsonReader.readObject();

        this.setName(dataObject.getString("athleteName"));
        this.setDescription(dataObject.getString("athleteDesc"));

        String athleteStats = dataObject.getString("athleteStats");

        this.statistics.addGame(athleteStats);
    }

    public String getName()
    {
        return this.name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    private void setDescription(String description)
    {
        this.description = description;
    }

    public Double getAthleteValue()
    {
        return this.statistics.getAthleteValue();
    }

    public String getAthleteStatisticsJson()
    {
        return this.statistics.getAthleteStatisticsJson();
    }
}
