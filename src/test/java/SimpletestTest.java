import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class SimpletestTest extends AbstractTestNGCucumberTests {
    private Simpletest calc ;

    double a;
    double b;
    double result;
    String[] hdr;
    String[] cols;
    String filename = "C:\\Users\\User\\IdeaProjects\\calctestng\\src\\test\\resources\\java\\test.csv";


    @Given("^two numbers (-?\\d) and (-?\\d)")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        this.calc = new Simpletest();
    }

    @When("^we try to find sum of our numbers")
    public void when() {

            try{
                FileWriter fileWriter =  new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                String text = Double.toString(calc.sum(a, b)) + ","  + Double.toString(a)+ "," + Double.toString(b)+"\n";
                bw.write(text);
                bw.close();

            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }

            try {
                FileReader fileReader = new FileReader(filename);
                BufferedReader fp = new BufferedReader(fileReader);



           /* hdr = fp.readLine().split(",");
            if(hdr != null)
                for(int i  = 1; i <= hdr.length; ++i)
                    System.out.print(hdr[i-1]);
            System.out.println();
*/
                while(fp.ready()){
                    cols = fp.readLine().split(",");
                    for(int i  = 1; i <= cols.length; ++i)
                        System.out.print(cols[i-1]+" ");
                    System.out.println();
                    //cols = null;
                }
                fp.close();
                fp  = null;
                hdr = null;
            } catch(Exception e){
                e.printStackTrace();
            }
            /*String str = "1.5,0,12345";
            String[] str1 = str.split(",") ;
            System.out.print(str1[1]);*/
        }


    @Then("^result should be (-?\\d)") //(\\.\\d)?)
    public void then(double res) {
        this.result = res;
        double[] col = new double[3];
        for (int i = 0; i<3; i++){
            col[i] = Double.parseDouble(cols[i]);
        }
        Assert.assertEquals(col[0], result, 0.0001);
        Assert.assertEquals(col[1], a, 0.0001);
        Assert.assertEquals(col[2], b, 0.0001);


    }

}