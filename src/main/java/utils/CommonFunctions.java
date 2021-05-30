package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;
    public static String propertiesFilePath =  new File("src/main/resources/testData/config.properties").getAbsolutePath();
    public static String errorShotsPath = new File("src/main/resources/errorShots").getAbsolutePath();


    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void waitForTime(int waittime)
    {
        driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
    }

    public void mouseOver(WebElement element)
    {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public String readProperty(String key) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(propertiesFilePath);
        Properties properties = new Properties();
        properties.load(inputStream);
        String value =  properties.getProperty(key);
        return value;
    }

    public void takeScreenshot(String fileName) throws Exception
    {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(errorShotsPath+"/"+fileName);
        FileUtils.copyFile(srcFile, destFile);
    }
}
