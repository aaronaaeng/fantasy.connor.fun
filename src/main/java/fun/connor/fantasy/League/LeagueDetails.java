package fun.connor.fantasy.League;

import fun.connor.fantasy.Athlete.AthleteType;

import java.util.UUID;

class LeagueDetails {
    private final UUID leagueId;
    private final AthleteType athleteType;
    private final Double teamBudget;

    LeagueDetails(UUID leagueId, AthleteType athleteType, Double teamBudget)
    {
        this.leagueId = leagueId;
        this.athleteType = athleteType;
        this.teamBudget = teamBudget;
    }
}
