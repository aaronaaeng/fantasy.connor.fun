package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.AthleteType;

import java.util.UUID;

/**
 * This class is merely a data class used to reduce the amount of data sent to the frontend in some situations.  This
 * is created then immediately serialized to JSON and sent as a REST response.
 */
class LeagueDetails {
    private final UUID leagueId;
    private final AthleteType athleteType;
    private final Double teamBudget;

    /**
     * This constructs the LeagueDetails object.  It contains a basic overview of the league.
     * @param leagueId The ID of the league
     * @param athleteType The type of athlete used in the league
     * @param teamBudget The starting budget for each team
     */
    LeagueDetails(UUID leagueId, AthleteType athleteType, Double teamBudget)
    {
        this.leagueId = leagueId;
        this.athleteType = athleteType;
        this.teamBudget = teamBudget;
    }
}
