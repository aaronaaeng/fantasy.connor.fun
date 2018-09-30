package fun.connor.fantasy.Statistics;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParsingException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Aaron on 9/29/2018.
 */
public class BowlerStatistics extends Statistics {
    private ArrayList<Double> firstBallAverages = new ArrayList<Double>();
    private ArrayList<Double> multiPinSparePercentages = new ArrayList<Double>();
    private ArrayList<Double> singlePinSparePercentages = new ArrayList<Double>();
    private ArrayList<Double> speedAverages = new ArrayList<Double>();
    private ArrayList<Double> matchWinLoss = new ArrayList<Double>();

    @Override
    public boolean addGame(String gameStats)
    {
        try {
            JsonReader jsonReader = Json.createReader(new StringReader(gameStats));
            JsonObject dataObject = jsonReader.readObject();

            Double firstBallAverages = dataObject.getJsonNumber("firstBallAverage").doubleValue();
            Double multiPinSparePercentages = dataObject.getJsonNumber("multiPinSparePercentage").doubleValue();
            Double singlePinSparePercentages = dataObject.getJsonNumber("singlePinSparePercentage").doubleValue();
            Double speedAverages = dataObject.getJsonNumber("speedAverage").doubleValue();
            Double matchWinLoss = dataObject.getJsonNumber("mathWinLoss").doubleValue();

            this.firstBallAverages.add(firstBallAverages);
            this.multiPinSparePercentages.add(multiPinSparePercentages);
            this.singlePinSparePercentages.add(singlePinSparePercentages);
            this.speedAverages.add(speedAverages);
            this.matchWinLoss.add(matchWinLoss);
        }
        catch (JsonParsingException e) {
            return false;
        }
        return true;
    }

    private Double getFirstBallAverage()
    {
        return this.getListAverage(this.firstBallAverages);
    }

    private Double getMultiPinSparePercentage() {
        return this.getListAverage(this.multiPinSparePercentages);
    }

    private Double getSinglePinSparePercentage() {
        return this.getListAverage(this.singlePinSparePercentages);
    }

    private Double getSpeedAverage() {
        return this.getListAverage(this.speedAverages);
    }

    private Double getMatchWinPercentage()
    {
        return this.getListAverage(this.matchWinLoss);
    }

    @Override
    public String getAthleteStatisticsJson()
    {
        return javax.json.Json.createObjectBuilder()
                .add("firstBallAverage", this.getFirstBallAverage())
                .add("multiPinSparePercentage", this.getMultiPinSparePercentage())
                .add("singlePinSparePercentage", this.getSinglePinSparePercentage())
                .add("speedAverage", this.getSpeedAverage())
                .add("matchWinPercentage", this.getMatchWinPercentage())
                .build()
                .toString();
    }

    @Override
    public Double getAthleteValue()
    {
        return 0.0;
    }
}
