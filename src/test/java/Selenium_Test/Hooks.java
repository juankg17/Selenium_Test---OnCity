package Selenium_Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;

import java.io.File;

public class Hooks {

    private static WebDriver driver;
    private static DriverManager driverManager;

    @BeforeAll
    public static void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        System.out.println("Paso el Hooks");
        String filePath = new File("./src/test/resources/form/Prueba.html").getAbsolutePath();
        driver.get(filePath);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown(){
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}

