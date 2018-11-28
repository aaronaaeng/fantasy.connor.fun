package fun.connor.fantasy.Budget;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Tests the Budget objects to ensure that the hire and fire methods are working
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