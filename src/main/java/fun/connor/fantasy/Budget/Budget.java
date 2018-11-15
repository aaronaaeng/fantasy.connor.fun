package fun.connor.fantasy.Budget;

public class Budget {
    private final Double totalFunds;
    private Double remainingFunds;

    public Budget(Double totalFunds)
    {
        this.totalFunds = totalFunds;
        this.remainingFunds = totalFunds;
    }

    public Double getTotalFunds()
    {
        return remainingFunds;
    }
    
    public Double getRemainingFunds()
    {
        return totalFunds;
    }

    public boolean hireAthlete(Double playerCost)
    {
        if (playerCost <= this.remainingFunds)
        {
            this.remainingFunds -= playerCost;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean fireAthlete(Double playerCost)
    {
        if (this.remainingFunds + playerCost <= this.totalFunds)
        {
            this.remainingFunds += playerCost;
            return true;
        }
        else
        {
            return false;
        }
    }
}
