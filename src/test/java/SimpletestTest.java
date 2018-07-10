import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class SimpletestTest {
    private Simpletest calc = new Simpletest();

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {0, 0, 0},
                {5, 2, 3},
                {-5, -2, -3}
        };
    }

    @Test(dataProvider = "getData")
    public void testSum(int expRes, int op1, int op2) throws Exception {
        Assert.assertEquals(expRes, calc.sum(op1,op2));

    }
}