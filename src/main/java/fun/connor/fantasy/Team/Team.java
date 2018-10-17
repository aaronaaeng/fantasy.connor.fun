package fun.connor.fantasy.Team;

import fun.connor.fantasy.Budget.Budget;

import java.util.ArrayList;
import java.util.UUID;

public class Team {
    private Budget budget;
    private ArrayList<UUID> draftedAthletes;

    public Team(Budget budget)
    {
        this.budget = budget;
    }

    public boolean hireAthlete(UUID athleteId, Double athleteValue)
    {
        if (budget.hireAthlete(athleteValue))
        {
            draftedAthletes.add(athleteId);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean fireAthlete(UUID athleteId, Double athleteValue)
    {
        if (draftedAthletes.contains(athleteId) && budget.fireAthlete(athleteValue))
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
