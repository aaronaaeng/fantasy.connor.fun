package fun.connor.fantasy.Statistics;

import java.util.ArrayList;

/**
 * Created by Aaron on 9/29/2018.
 */
abstract public class Statistics {
    abstract public Double getAthleteValue();
    abstract public String getAthleteStatisticsJson();
    abstract public boolean addGame(String gameStats);

    protected Double getListAverage(ArrayList<Double> list)
    {
        Double total = 0.0;
        for(Double value : list)
        {
            total += value;
        }
        return total / list.size();
    }
}
