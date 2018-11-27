package fun.connor.fantasy.Budget;

/**
 * The Budget class contains information on a team's budget
 * @author Aaron Aaeng
 * @version 1.1
 */
public class Budget {
    private final Double totalFunds;
    private Double remainingFunds;

    /**
     * The constructor takes a double representing the total funds.
     * @param totalFunds The amount of starting funds
     */
    public Budget(Double totalFunds)
    {
        this.totalFunds = totalFunds;
        this.remainingFunds = totalFunds;
    }

    /**
     * Returns the original total funds of a team
     * @return The original total funds of a team
     */
    public Double getTotalFunds()
    {
        return remainingFunds;
    }

    /**
     * Returns the remaining funds of a team
     * @return The remaining funds of a team
     */
    public Double getRemainingFunds()
    {
        return totalFunds;
    }

    /**
     * This method checks whether the team has enough funds to hire an athlete.  If it does, the team's budget is
     * updated.
     * @param athleteCost The cost of the athlete being hired
     * @return An indication of whether the hiring was successful
     */
    public boolean hireAthlete(Double athleteCost)
    {
        if (athleteCost <= this.remainingFunds)
        {
            this.remainingFunds -= athleteCost;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method checks whether a player can be fired.  If successful, the cost of the fired athlete is added to the
     * team's remaining budget.  The firing fails if the refunded cost of the athlete would exceed the original total
     * team budget.
     * @param athleteCost The cost of the athlete being fired
     * @return An indication of whether the firing was successful
     */
    public boolean fireAthlete(Double athleteCost)
    {
        if (this.remainingFunds + athleteCost <= this.totalFunds)
        {
            this.remainingFunds += athleteCost;
            return true;
        }
        else
        {
            return false;
        }
    }
}
