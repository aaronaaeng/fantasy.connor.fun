package fun.connor.fantasy.Budget;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Aaron on 11/13/2018.
 */
public class BudgetTest {
    @Test
    public void testHireAthlete() throws Exception {
        Budget budget = new Budget(50.00);
        Boolean returnValue = budget.hireAthlete(50.00);
        Assert.assertTrue(returnValue);

        returnValue = budget.hireAthlete(50.00);
        Assert.assertFalse(returnValue);
    }

    @Test
    public void testFireAthlete() throws Exception {
        Budget budget = new Budget(50.00);
        budget.hireAthlete(50.00);
        Boolean returnValue = budget.fireAthlete(50.00);
        Assert.assertTrue(returnValue);

        returnValue = budget.fireAthlete(50.00);
        Assert.assertFalse(returnValue);
    }

}