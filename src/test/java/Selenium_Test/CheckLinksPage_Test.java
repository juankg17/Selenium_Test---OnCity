package Selenium_Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.CheckingLinksPage;

public class CheckLinksPage_Test {
    protected static WebDriver driver;
    private static CheckingLinksPage page;

    @BeforeAll
    public static void beforeClass(){
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        page = new CheckingLinksPage(driver);
        driver.get("https://www.oncity.com/");
    }

    @Test
    public void checkingLinks() throws Exception {
        Assertions.assertTrue(page.checkingPageLinks(), "There are broken links");
    }

    @AfterAll
    public static void afterClass(){
        driver.quit();
    }

}
