package browserManager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverMacManager extends DriverManager{

        @Override
        public void createDriver(){
            System.setProperty("webdriver.chrome.driver","/Users/juankg17/IdeaProjects/Selenium_Test - OnCity/src/test/resources/chromedriverMac/chromedriver");
            driver = new ChromeDriver();
        }

}
