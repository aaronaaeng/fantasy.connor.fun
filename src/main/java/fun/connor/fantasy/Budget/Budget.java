package fun.connor.fantasy.Budget;

public class Budget {
    private final Double totalFunds;
    private Double remainingFunds;

    Budget(Double totalFunds)
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

    public boolean hirePlayer(Double playerCost)
    {
        if (playerCost < this.remainingFunds)
        {
            this.remainingFunds -= playerCost;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean firePlayer(Double playerCost)
    {
        if (this.remainingFunds + playerCost < this.totalFunds)
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
