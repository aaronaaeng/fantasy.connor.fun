package fun.connor.fantasy.Team;

import fun.connor.fantasy.Budget.Budget;

import java.util.HashMap;
import java.util.UUID;

/**
 * The Team class provides all information for a team.  This includes the owner, roster, and budget.
 */
public class Team {
    /**
     * The username of the team's owner
     */
    private final String owner;

    /**
     * The ID of the team
     */
    private final UUID teamId;

    /**
     * A reference to the team's budget object
     */
    private final Budget budget;

    /**
     * A map of drafted athletes' values keyed on their IDs
     */
    private final HashMap<UUID, Double> draftedAthletes = new HashMap<>();

    /**
     * The team's current score
     */
    private Double teamScore = 0.0;

    /**
     * This creates a new team with the given parameters
     * @param owner The username of the owner
     * @param budget The budget object for the team
     */
    public Team(String owner, Budget budget)
    {
        this.owner = owner;
        this.teamId = UUID.randomUUID();
        this.budget = budget;
        updateTeamScore();
    }

    /**
     * This handles the hiring of a new athlete
     * @param athleteId The ID of the athlete to be hired
     * @param athleteValue The value of the athlete to be hired
     * @return A flag indicating whether the hiring was successful
     */
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

    /**
     * This handles the firing of a new athlete
     * @param athleteId The ID of the athlete to be fired
     * @return A flag indicating whether the firing was successful
     */
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

    /**
     * Updates the team's score
     */
    // The math behind doing this properly is far to complicated to be part of this project
    private void updateTeamScore()
    {
        this.teamScore = (Math.random()*((150)+1));
    }

    /**
     * Returns the team's score
     * @return The team's score
     */
    public Double getTeamScore()
    {
        return this.teamScore;
    }

    /**
     * Returns the team's owner
     * @return The team's owner
     */
    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Returns the tea's ID
     * @return The tea's ID
     */
    public UUID getTeamId()
    {
        return this.teamId;
    }
}
