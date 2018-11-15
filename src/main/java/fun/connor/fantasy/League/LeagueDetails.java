package fun.connor.fantasy.League;

import java.util.UUID;

class LeagueDetails {
    private final UUID leagueId;
    private final String athleteType;
    private final Double teamBudget;

    LeagueDetails(UUID leagueId, String athleteType, Double teamBudget)
    {
        this.leagueId = leagueId;
        this.athleteType = athleteType;
        this.teamBudget = teamBudget;
    }
}
