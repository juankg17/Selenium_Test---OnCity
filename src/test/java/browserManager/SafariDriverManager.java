package browserManager;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager{

    @Override
    public void createDriver(){
        driver = new SafariDriver();
    }
}
