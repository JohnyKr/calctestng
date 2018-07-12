import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.*;

public class TaxNumberGeneratorTest {
    private TaxNumberGenerator gen = new TaxNumberGenerator();

    @Test
    public void getRandomRegionNumberTest () throws Exception{
        Assert.assertEquals(1-83,Integer.parseInt( gen.getRandomRegionNumber(gen.getRegionNumbers())));

    }


}