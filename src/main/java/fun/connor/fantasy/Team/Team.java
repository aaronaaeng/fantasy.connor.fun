package fun.connor.fantasy.Team;

import fun.connor.fantasy.Budget.Budget;

import java.util.HashMap;
import java.util.UUID;

public class Team {
    private final String owner;
    private final UUID teamId;
    private final Budget budget;
    private final HashMap<UUID, Double> draftedAthletes = new HashMap<>();
    private Double teamScore = 0.0;

    public Team(String owner, Budget budget)
    {
        this.owner = owner;
        this.teamId = UUID.randomUUID();
        this.budget = budget;
        updateTeamScore();
    }

    public boolean hireAthlete(UUID athleteId, Double athleteValue)
    {
        if (!draftedAthletes.containsKey(athleteId) && budget.hireAthlete(athleteValue))
        {
            draftedAthletes.put(athleteId, athleteValue);
            updateTeamScore();
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

    private void updateTeamScore()
    {
        this.teamScore = (Math.random()*((150)+1));
    }

    public Double getTeamScore()
    {
        return this.teamScore;
    }

    public String getOwner() { return this.owner; }

    public UUID getTeamId()
    {
        return this.teamId;
    }
}
