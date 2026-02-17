package Selenium_Test;

import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pom.*;

import java.io.File;

public class TestBase {

    protected static WebDriver driver;
    private static DriverManager driverManager;

    @BeforeAll
    public static void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        //String filePath = new File("./src/test/resources/form/Prueba.html").getAbsolutePath();
        //driver.get(filePath);
        //driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        driver.get("https://www.oncity.com/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown(){
        //driverManager.quitDriver();
    }
}