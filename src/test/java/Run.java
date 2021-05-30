
import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features=".", dryRun = false,tags="@search",
        plugin = {"pretty", "html:target/cucumber.html"})
public class Run {

   /* public static String xmlFilePath = new File("src/main/resources/reportConfig/extentConfig.xml").getAbsolutePath();

    @AfterClass
    public static void generateTestReport()
    {
        Reporter.loadXMLConfig(xmlFilePath);
    }*/
}
