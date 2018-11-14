package fun.connor.fantasy.Team;

import fun.connor.fantasy.Budget.Budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Team {
    private Budget budget;
    private HashMap<UUID, Double> draftedAthletes = new HashMap<>();

    public Team(Budget budget)
    {
        this.budget = budget;
    }

    public boolean hireAthlete(UUID athleteId, Double athleteValue)
    {
        if (!draftedAthletes.containsKey(athleteId) && budget.hireAthlete(athleteValue))
        {
            draftedAthletes.put(athleteId, athleteValue);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean fireAthlete(UUID athleteId)
    {
        if (draftedAthletes.containsKey(athleteId) && budget.fireAthlete(draftedAthletes.get(athleteId)))
        {
            draftedAthletes.remove(athleteId);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Double getTeamScore()
    {
        return 0.0;
    }
}
